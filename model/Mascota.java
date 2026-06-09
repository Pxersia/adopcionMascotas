package model;

public abstract class Mascota {
    protected String nombre;
    protected int edad;

    public Mascota(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void hacerSonido();

    public void mostrarInfo() {
        System.out.println(nombre + " | Edad: " + edad);
    }
}

