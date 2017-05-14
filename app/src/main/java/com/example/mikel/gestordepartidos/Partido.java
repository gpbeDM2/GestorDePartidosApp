package com.example.mikel.gestordepartidos;


public class Partido {

    /*private Equipo equipo;
    private Entrenador arbitro;
    private Entrenador mesa;
    private Hora hora;*/

    private String equipo;
    private String arbitro;
    private String mesa;
    private String hora;


    public Partido() {
        super();
    }

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

    /*public Partido(Equipo e, Entrenador ar, Entrenador m, Hora h) {

        equipo = e;
        arbitro = ar;
        mesa = m;
        hora = h;

    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo e) {
        equipo = e;
    }

    public Entrenador getArbitro() {
        return arbitro;
    }

    public void setArbitro(Entrenador ar) {
        arbitro = ar;
    }

    public Entrenador getMesa() {
        return mesa;
    }

    public void setMesa(Entrenador m) {
        mesa = m;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora h) {
        hora = h;
    }
*/

}
