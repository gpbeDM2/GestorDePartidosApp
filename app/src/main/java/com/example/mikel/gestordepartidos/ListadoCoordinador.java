package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoCoordinador extends AppCompatActivity {
    private ListView lista;
    private String usuario;
    private ImageButton menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_coordinador);
        menu = (ImageButton) findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListadoCoordinador.this, menuCrear.class);
                startActivity(intent);
            }
        });

        Intent in = getIntent();
        usuario = in.getStringExtra("usuario");

        SQLiteBBDD sqdb = new SQLiteBBDD();
        ArrayList<Partido> partidos = sqdb.partidos();
        if(partidos!=null) {
            String[] datos = new String[partidos.size()];
            for (int i = 0; i < partidos.size(); i++) {
                datos[i] = partidos.get(i).getEquipo() + " " + partidos.get(i).getHora();
            }

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, datos);
            lista = (ListView) findViewById(R.id.listado_invitado_Lst);
            lista.setAdapter(adaptador);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Partido p = (Partido) lista.getItemAtPosition(position);
                    Intent intent = new Intent(ListadoCoordinador.this, EditarPartidoCoordinador.class);
                    intent.putExtra("equipo", p.getEquipo());
                    intent.putExtra("arbitro", p.getArbitro());
                    intent.putExtra("mesa", p.getMesa());
                    intent.putExtra("hora", p.getHora());
                    intent.putExtra("hora", p.getHora());
                    intent.putExtra("usuario",usuario);
                    startActivity(intent);
                }
            });
        } else {
        Toast.makeText(this, "Error al cargar los partidos", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coordinador, menu);
        return true;
    }

}
