package com.example.mikel.gestordepartidos;


public class Partido {

    private Equipo equipo;
    private Entrenador arbitro;
    private Entrenador mesa;
    private Hora hora;


    public Partido() {
        super();
    }

    public Partido(Equipo e, Entrenador ar, Entrenador m, Hora h) {

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


}
