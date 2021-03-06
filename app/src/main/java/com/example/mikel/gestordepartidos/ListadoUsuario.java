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

public class ListadoUsuario extends AppCompatActivity {
    private ListView lista;
    private String usuario;

    public void actualizar(View v) {
        this.cargar();
    }

    public void cargar(){
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

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    Partido p = (Partido) lista.getItemAtPosition(position);
                    Intent intent = new Intent(ListadoUsuario.this, EditarPartidoUsuario.class);
                    intent.putExtra("equipo",p.getEquipo());
                    intent.putExtra("arbitro",p.getArbitro());
                    intent.putExtra("mesa",p.getMesa());
                    intent.putExtra("usuario",usuario);
                    startActivity(intent);
                }
            });
        } else {
            Toast.makeText(this, "Error al cargar los partidos", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_usuario);

        Intent in = getIntent();

        usuario = in.getStringExtra("usuario");

        this.cargar();
    }
}
