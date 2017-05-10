package com.example.mikel.gestordepartidos;



public class Hora {

    private int horas;
    private int minutos;

    public Hora(){
        super();
    }


    public Hora(int h,int min){
        horas =h;
        minutos = min;
    }

    public String toString(){
        return horas+":"+minutos;
    }
}

