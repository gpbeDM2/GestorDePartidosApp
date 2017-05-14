package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditarPartidoCoordinador extends AppCompatActivity {
    private TextView e,h,a,m, horaFecha;
    private String equipo, arbitro, mesa, fecha, usuario, horaElegida, fechaElegida;

    public void elegirhora(View v) {
        Intent intent = new Intent(EditarPartidoCoordinador.this, elegirHora.class);
        startActivityForResult(intent, 1234);
        intent = new Intent(EditarPartidoCoordinador.this, elegirFecha.class);
        startActivityForResult(intent, 4321);

        horaFecha.setText(fechaElegida + " " + horaElegida);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_partido_coordinador);

        horaFecha = (TextView) findViewById(R.id.editar_partido_coordinador_hora);

        Intent intent = getIntent();

        equipo  = intent.getStringExtra("equipo");
        arbitro = intent.getStringExtra("arbitro");
        mesa    = intent.getStringExtra("mesa");
        fecha   = intent.getStringExtra("hora");
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

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            horaElegida = data.getExtras().getString("hora");
        }
        if (requestCode == 4321 && resultCode == RESULT_OK) {
            fechaElegida = data.getExtras().getString("fecha");
        }
    }
}
