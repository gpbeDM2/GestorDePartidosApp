package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuCrear extends AppCompatActivity {
    Button bcrear_Partido, bcrear_entrenador, bcrear_equipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_crear);
        bcrear_Partido = (Button) findViewById(R.id.crear_partido);
        bcrear_equipo = (Button) findViewById(R.id.crear_equipo);
        bcrear_entrenador = (Button) findViewById(R.id.crear_entrenador);

        bcrear_Partido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(menuCrear.this, crearPartido.class);
                startActivity(intent);

            }
        });

        bcrear_equipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(menuCrear.this, CrearEquipo.class);
                startActivity(intent);

            }
        });

        bcrear_entrenador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(menuCrear.this, CrearEntrenador.class);
                startActivity(intent);

            }
        });
    }
}
