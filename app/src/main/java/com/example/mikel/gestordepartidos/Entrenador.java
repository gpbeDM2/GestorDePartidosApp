package com.example.mikel.gestordepartidos;


public class Entrenador {

    private String nombre;
    private int id;

    public Entrenador() {
        super();
    }

    public Entrenador(String n, int i) {

        nombre = n;
        id = i;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return nombre;
    }
}
