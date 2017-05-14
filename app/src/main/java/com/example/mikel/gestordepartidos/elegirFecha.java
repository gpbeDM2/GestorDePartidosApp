package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class elegirFecha extends AppCompatActivity {

    CalendarView calendario;
    Button confirmar;
    String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_fecha);
        calendario = (CalendarView) findViewById(R.id.calendario);
        confirmar = (Button) findViewById(R.id.confirmar_fecha);


        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                fecha = dayOfMonth + "/"+month+"/"+year;
            }
        });

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("fecha", fecha);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
