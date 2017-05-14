package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoInvitado extends AppCompatActivity {
    private ListView lista;

    public void actualizar(View v) {
        this.cargar();
    }

    public void cargar(){
        ArrayList<Partido> partidos = MainActivity.sqdb.partidos();
        if(partidos!=null) {
            String[] datos = new String[partidos.size()];
            for(int i=0;i<partidos.size();i++){
                datos[i] = partidos.get(i).getEquipo() + " " + partidos.get(i).getHora();
            }

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, datos);
            lista = (ListView)findViewById(R.id.listado_invitado_Lst);
            lista.setAdapter(adaptador);
        } else {
            Toast.makeText(this, "Error al cargar los partidos", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_invitado);

        this.cargar();

        //Para ver el resultado.
        String[] datos =    {"Infantil A\n02/03/17\t10:00",
                             "Infantil B\n02/03/17\t12:00",
                             "Cadetes\n09/03/17\t9:00",
                             "Alebin A\n09/03/17\t12:00",
                             "Alebin B\n014/03/17\t12:00"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, datos);
        lista = (ListView)findViewById(R.id.listado_invitado_Lst);
        lista.setAdapter(adaptador);
    }
}
