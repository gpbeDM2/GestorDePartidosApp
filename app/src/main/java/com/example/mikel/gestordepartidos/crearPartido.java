package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class crearPartido extends AppCompatActivity {

    Button elegirHora, elegirFecha, confirmarPartido;
    TextView horaElegida, fechaElegida;
    Spinner spinner;
    SQLiteBBDD sqdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_partido);

        sqdb = new SQLiteBBDD();
        ArrayList<String> array = sqdb.equipos();

        spinner = (Spinner) findViewById(R.id.spin_equipo);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        confirmarPartido    = (Button) findViewById(R.id.confirmar_partido);
        elegirFecha         = (Button) findViewById(R.id.elegirFecha);
        elegirHora          = (Button) findViewById(R.id.elegirHora);
        horaElegida         = (TextView) findViewById(R.id.horaElegida);
        fechaElegida        = (TextView) findViewById(R.id.fechaElegida);

        confirmarPartido.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String equipo = spinner.getSelectedItem().toString();
                String fecha  = fechaElegida + " " + horaElegida;
                boolean b = sqdb.crearPartido(equipo, fecha);
                if(b) {
                    Toast.makeText(null, "Insercion realizada correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(null, "Error durante la insercion", Toast.LENGTH_SHORT).show();
                }
            }
        });

        elegirHora.setOnClickListener(new View.OnClickListener() {
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
