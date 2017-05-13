package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class elegirHora extends AppCompatActivity {

    TimePicker reloj;
    Button confirmar;
    String hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_hora);
        reloj = (TimePicker) findViewById(R.id.timePicker);
        confirmar = (Button) findViewById(R.id.confirmar_hora);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                hora = reloj.getHour() + ":" + reloj.getMinute();

                Intent intent = new Intent();
                intent.putExtra("hora", hora);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
