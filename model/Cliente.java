package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private List<Mascota> mascotas = new ArrayList<>();

    public Cliente(String nombre) {
        super(nombre);
    }

    public void agregarMascota(Mascota m) {
        for (Mascota existente : mascotas) {
            if (existente.getNombre().equalsIgnoreCase(m.getNombre())) {
                System.out.println("Mascota ya registrada.");
                return;
            }
        }
        mascotas.add(m);
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }
}
