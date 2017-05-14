package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EditarPartidoCoordinador extends AppCompatActivity {
    private TextView e,h,a,m;
    private String equipo, arbitro, mesa, fecha, usuario;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_partido_coordinador);


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
