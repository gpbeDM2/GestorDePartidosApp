package com.example.mikel.gestordepartidos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class crearPartido extends AppCompatActivity {

    private EditText nuevoHora, nuevoMinutos;
    private Button horaAbajo, horaArriba, minutosAbajo, minutosArriba, confirmarPartido;
    private final int HORA_MAX = 23;
    private final int HORA_MIN = 0;
    private final int MINUTOS_MAX = 60;
    private final int DOS_CIFRAS = 9;
    private int hora, minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_partido);

        nuevoHora = (EditText) findViewById(R.id.nuevo_hora);
        nuevoMinutos = (EditText) findViewById(R.id.nuevo_minutos);
        horaAbajo = (Button) findViewById(R.id.hora_abajo);
        horaArriba = (Button) findViewById(R.id.hora_arriba);
        minutosAbajo = (Button) findViewById(R.id.minuto_abajo);
        minutosArriba = (Button) findViewById(R.id.minuto_arriba);

        horaArriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hora = Integer.parseInt(nuevoHora.getText().toString());
                hora = +1;
                if (hora > DOS_CIFRAS) {
                    nuevoHora.setText(hora);
                } else {
                    nuevoHora.setText("0" + hora);
                }

                if (hora > HORA_MAX) {
                    hora = 0;
                    nuevoHora.setText("00");
                }
            }
        });


        horaAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hora = Integer.parseInt(nuevoHora.getText().toString());
                hora = -1;
                if (hora <= DOS_CIFRAS) {
                    nuevoHora.setText("0"+hora);
                } else {
                    nuevoHora.setText(hora);
                }

                if (hora > HORA_MIN) {
                    hora = 23;
                    nuevoHora.setText("23");
                }
            }
        });
    }
}
