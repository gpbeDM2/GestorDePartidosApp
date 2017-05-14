package com.example.mikel.gestordepartidos;


public class Partido {

    private String equipo;
    private String arbitro;
    private String mesa;
    private String hora;


    public Partido(String e, String ar, String m, String h) {
        equipo = e;
        arbitro = ar;
        mesa = m;
        hora = h;

    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String e) {
        equipo = e;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String ar) {
        arbitro = ar;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String m) {
        mesa = m;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String h) {
        hora = h;
    }

}
