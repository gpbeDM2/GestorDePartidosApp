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

public class ListadoCoordinador extends AppCompatActivity {
    private ListView lista;
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
        final String[] datos = new String[] {"Elemento 1","Elemento 2",
                "Elemento 3","Elemento 4", "Elemento 5"};
        /*Esos datos hay que cambiarlos por una consulta a la base de datos*/
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, datos);
        lista = (ListView)findViewById(R.id.listado_coordinador_Lst);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Object o = lista.getItemAtPosition(position);
                Equipo eq=(Equipo) o;
                Toast.makeText(getBaseContext(),o.toString(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListadoCoordinador.this, EditarPartidoCoordinador.class);
                intent.putExtra("equipo1","nombre equipo1");
                intent.putExtra("equipo2","nombre equipo2");
                intent.putExtra("hora","la hora");
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coordinador, menu);
        return true;
    }

}
