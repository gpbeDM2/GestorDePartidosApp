package com.example.mikel.gestordepartidos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CrearEquipo extends AppCompatActivity {

    Button bcrearEquipo;
    Spinner spinner1, spinner2;
    SQLiteBBDD sqdb;
    EditText txtNombre;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_equipo);

        bcrearEquipo    = (Button) findViewById(R.id.bcrearEquipo);
        spinner1        = (Spinner) findViewById(R.id.spinner_entrenador1);
        spinner2        = (Spinner) findViewById(R.id.spinner_entrenador2);
        txtNombre       = (EditText)findViewById(R.id.txtNombre);

        sqdb = new SQLiteBBDD();
        ArrayList<Entrenador> array = sqdb.entrenadores();


        ArrayAdapter<Entrenador> spinnerArrayAdapter = new ArrayAdapter<Entrenador>(this, android.R.layout.simple_spinner_item, array); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinnerArrayAdapter);
        spinner2.setAdapter(spinnerArrayAdapter);

        bcrearEquipo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(txtNombre.getText().toString().equals(""))
                {
                    Toast.makeText(null, "Por favor introduzca el nombre del equipo", Toast.LENGTH_SHORT).show();
                } else {
                    Entrenador ent1 = (Entrenador) spinner1.getSelectedItem();
                    Entrenador ent2 = (Entrenador) spinner2.getSelectedItem();
                    boolean b = sqdb.crearEquipo(txtNombre.getText().toString(), ent1.getId(), ent2.getId());
                    if (b) {
                        Toast.makeText(null, "Insercion realizada correctamente", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(null, "Error durante la insercion", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
