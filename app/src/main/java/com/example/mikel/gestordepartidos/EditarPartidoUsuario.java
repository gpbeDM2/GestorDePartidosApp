package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EditarPartidoUsuario extends AppCompatActivity {
    private TextView e,h,a,m;
    private String equipo, arbitro, mesa, fecha, usuario;

    public void addarbitro(View v){
        if(a.getText().toString().equals("")){
            SQLiteBBDD sqdb = new SQLiteBBDD();
            boolean b = sqdb.editarPartidoA(usuario, equipo, fecha);
            if(b) {
                Toast.makeText(this, "Insercion realizada correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error inesperado en la insercion", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Ya hay un arbitro para este partido", Toast.LENGTH_SHORT).show();
        }
    }

    public void addmesa(View v){
        if(m.getText().toString().equals("")){
            SQLiteBBDD sqdb = new SQLiteBBDD();
            boolean b = sqdb.editarPartidoM(usuario, equipo, fecha);
            if(b) {
                Toast.makeText(this, "Insercion realizada correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error inesperado en la insercion", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Ya hay un arbitro para este partido", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_partido_usuario);

        Intent intent = getIntent();

        equipo  = intent.getStringExtra("equipo");
        arbitro = intent.getStringExtra("arbitro");
        mesa    = intent.getStringExtra("mesa");
        fecha    = intent.getStringExtra("hora");
        usuario = intent.getStringExtra("usuario");

        e = (TextView) findViewById(R.id.editar_partido_usuario_equipo);
        h = (TextView) findViewById(R.id.editar_partido_usuario_hora);
        a = (TextView) findViewById(R.id.editar_partido_usuario_arbitro);
        m = (TextView) findViewById(R.id.editar_partido_usuario_mesa);

        e.setText(equipo);
        h.setText(fecha);
        a.setText(arbitro);
        m.setText(mesa);
    }
}
