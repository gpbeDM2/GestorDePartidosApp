package com.example.mikel.gestordepartidos;

import java.util.Date;

public class partido {
    Equipo local;
    Equipo visitante;
    Date hora;
    String arbitro;
    String mesa;

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public partido(Equipo loc, Equipo vis, Date hor, String arb, String mes) {
        local=loc;
        visitante=vis;
        hora=hor;
        arbitro=arb;
        mesa=mes;

    }
}
