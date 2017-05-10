package com.example.mikel.gestordepartidos;


public class Entrenador {

    private String nombre;
    private String apellido;
    private Equipo equipo;

    public Entrenador() {
        super();
    }

    public Entrenador(String n, String ape, Equipo equip) {

        nombre = n;
        apellido = ape;
        equipo = equip;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String ape) {
        this.apellido = ape;
    }

    public Equipo getEquipo() {
        return equipo;
    }


    public void setApellido(Equipo e) {
        this.equipo = e;
    }


}
