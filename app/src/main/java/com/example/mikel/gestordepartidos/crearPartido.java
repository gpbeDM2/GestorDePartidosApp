package com.example.mikel.gestordepartidos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class crearPartido extends AppCompatActivity {

    private TextView nuevoHora, nuevoMinutos;
    private Button horaAbajo, horaArriba, minutosAbajo, minutosArriba, confirmarPartido;
    private final int HORA_MAX = 23;
    private final int HORA_MIN = 0;
    private final int MINUTOS_MAX = 59;
    private final int DOS_CIFRAS = 9;
    private int hora, minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_partido);

        nuevoHora = (TextView) findViewById(R.id.nuevo_hora);
        nuevoMinutos = (TextView) findViewById(R.id.nuevo_minutos);
        horaAbajo = (Button) findViewById(R.id.hora_abajo);
        horaArriba = (Button) findViewById(R.id.hora_arriba);
        minutosAbajo = (Button) findViewById(R.id.minuto_abajo);
        minutosArriba = (Button) findViewById(R.id.minuto_arriba);

        horaArriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subirHora();

            }
        });


        horaAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bajarHora();

            }
        });

        minutosAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutos = Integer.parseInt(nuevoMinutos.getText().toString());
                minutos = minutos - 5;
                if (minutos < HORA_MIN) {
                    minutos = 55;
                    bajarHora();
                }
                if (minutos > DOS_CIFRAS) {
                    nuevoMinutos.setText("" + minutos);
                } else {
                    nuevoMinutos.setText("0" + minutos);
                }
            }
        });

        minutosArriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutos = Integer.parseInt(nuevoMinutos.getText().toString());
                minutos = minutos + 5;
                if (minutos > MINUTOS_MAX) {
                    minutos = 00;
                    subirHora();
                }
                if (minutos > DOS_CIFRAS) {
                    nuevoMinutos.setText("" + minutos);
                } else {
                    nuevoMinutos.setText("0" + minutos);
                }
            }
        });
    }

    public void subirHora() {
        hora = Integer.parseInt(nuevoHora.getText().toString());
        hora = hora + 1;
        if (hora > HORA_MAX) {
            hora = 0;

        }
        if (hora > DOS_CIFRAS) {
            nuevoHora.setText(hora + "");
        } else {
            nuevoHora.setText("0" + hora);
        }
    }

    public void bajarHora() {
        hora = Integer.parseInt(nuevoHora.getText().toString());
        hora = hora - 1;
        if (hora < HORA_MIN) {
            hora = 23;
        }
        if (hora > DOS_CIFRAS) {
            nuevoHora.setText("" + hora);
        } else {
            nuevoHora.setText("0" + hora);
        }
    }
}
