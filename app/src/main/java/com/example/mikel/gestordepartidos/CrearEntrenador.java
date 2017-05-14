package com.example.mikel.gestordepartidos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CrearEntrenador extends AppCompatActivity {
    private EditText txtNombre, txtCon;
    private Button bcrearEntrenador;
    private SQLiteBBDD sqdb;
    public Context c;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_entrenador);

        txtNombre             = (EditText) findViewById(R.id.txtNombre);
        txtCon             = (EditText) findViewById(R.id.txtCon);
        bcrearEntrenador    = (Button) findViewById(R.id.bcrearEntrenador);
        c = this.getApplicationContext();

        bcrearEntrenador.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nombre = txtNombre.getText().toString();
                String contrasena = txtCon.getText().toString();
                if(nombre.equals("") || contrasena.equals("")) {
                    Toast.makeText(c, "Inserta el nombre del entrenador y la contrasena", Toast.LENGTH_SHORT);
                } else {
                    sqdb = new SQLiteBBDD();
                    boolean b = sqdb.crearEntrenador(nombre,contrasena);
                    if(b) {
                        Toast.makeText(c, "Insercion realizada correctamente", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(c, "Error durante la insercion", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
