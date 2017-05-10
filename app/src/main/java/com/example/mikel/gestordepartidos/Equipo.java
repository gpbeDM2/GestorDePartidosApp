package com.example.mikel.gestordepartidos;

public class Equipo {


    private String nombre;
    private Entrenador primer_entrenador;
    private Entrenador segundo_entrenador;


    public Equipo() {
        super();
    }

    public Equipo(String n, Entrenador e1, Entrenador e2) {

        nombre = n;
        primer_entrenador = e1;
        segundo_entrenador = e2;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Entrenador getPrimero() {
        return primer_entrenador;
    }


    public void setPrimero(Entrenador e1) {
        this.primer_entrenador = e1;
    }

    public Entrenador getSegundo() {
        return segundo_entrenador;
    }


    public void setSegundo(Entrenador e2) {
        this.segundo_entrenador = e2;

    }
}
