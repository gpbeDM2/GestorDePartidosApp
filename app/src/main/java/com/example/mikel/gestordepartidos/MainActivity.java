package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    protected void invitado(View v){
        Intent intent = new Intent(MainActivity.this, ListadoInvitado.class);
        startActivity(intent);
    }
    public void usuario(View v){
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
