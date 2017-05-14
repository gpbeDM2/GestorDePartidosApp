package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class crearPartido extends AppCompatActivity {

    Button elegirHora, elegirFecha;
    TextView horaElegida, fechaElegida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_partido);
        elegirFecha = (Button) findViewById(R.id.elegirFecha);
        elegirHora = (Button) findViewById(R.id.elegirHora);
        horaElegida = (TextView) findViewById(R.id.horaElegida);
        fechaElegida = (TextView) findViewById(R.id.fechaElegida);


        elegirHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(crearPartido.this, elegirHora.class);
                startActivityForResult(intent, 1234);


            }
        });

        elegirFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crearPartido.this, elegirFecha.class);
                startActivityForResult(intent, 4321);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            String hora = data.getExtras().getString("hora");
            horaElegida.setText(hora);

        }
        if (requestCode == 4321 && resultCode == RESULT_OK) {
            String fecha = data.getExtras().getString("fecha");
            fechaElegida.setText(fecha);
        }
    }

}
