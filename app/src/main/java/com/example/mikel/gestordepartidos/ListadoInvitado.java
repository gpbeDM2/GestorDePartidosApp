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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_invitado);

        SQLiteBBDD sqdb = new SQLiteBBDD();
        ArrayList<Partido> partidos = sqdb.partidos();
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
}
