package service;

import model.Cliente;
import model.Mascota;
import model.Perro;
import model.Gato;
import util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class RefugioService {

    private List<Cliente> clientes = new ArrayList<>();

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== REFUGIO ANIMAL ===");
            System.out.println("1) Crear cliente");
            System.out.println("2) Registrar mascota");
            System.out.println("3) Ver clientes y mascotas");
            System.out.println("0) Salir");

            int op = InputUtil.leerInt();

            switch (op) {
                case 1 -> crearCliente();
                case 2 -> registrarMascota();
                case 3 -> mostrarDatos();
                case 0 -> salir = true;
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void crearCliente() {
        System.out.println("Ingrese nombre del cliente:");
        String nombre = InputUtil.leerString();
        clientes.add(new Cliente(nombre));
        System.out.println("Cliente creado con éxito.");
    }

    private void registrarMascota() {
        if (clientes.isEmpty()) {
            System.out.println("Primero debe crear un cliente.");
            return;
        }

        System.out.println("Seleccione cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ") " + clientes.get(i).getNombre());
        }

        int idx = InputUtil.leerInt() - 1;
        if (idx < 0 || idx >= clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }

        Cliente cliente = clientes.get(idx);

        System.out.println("Ingrese nombre de la mascota:");
        String nombreMascota = InputUtil.leerString();
        System.out.println("Ingrese edad de la mascota:");
        int edad = InputUtil.leerInt();

        System.out.println("Tipo de mascota: 1) Perro  2) Gato");
        int tipo = InputUtil.leerInt();

        Mascota mascota;
        if (tipo == 1) {
            mascota = new Perro(nombreMascota, edad);
        } else if (tipo == 2) {
            mascota = new Gato(nombreMascota, edad);
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        cliente.agregarMascota(mascota);
        System.out.println("Mascota registrada con éxito.");
    }

    private void mostrarDatos() {
        for (Cliente c : clientes) {
            System.out.println("\nCliente: " + c.getNombre());
            for (Mascota m : c.getMascotas()) {
                m.mostrarInfo();
                m.hacerSonido();
                if (m instanceof Perro perro) {
                    perro.entrenar();
                }
                if (m instanceof Gato gato) {
                    System.out.println(gato.datosAdopcion());
                }
            }
        }
    }
}
