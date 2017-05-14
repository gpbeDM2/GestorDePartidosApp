package com.example.mikel.gestordepartidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public EditText login_edusuario, login_edpassword;
    public void conexion(View v) {
        login_edpassword = (EditText) findViewById(R.id.login_edpassword);
        login_edusuario = (EditText) findViewById(R.id.login_edusuario);

        if(login_edpassword.getText().toString().equals("")||login_edusuario.getText().toString().equals("")) {
            Toast.makeText(this,"Faltan parametros",Toast.LENGTH_SHORT).show();
        } else {
            boolean b;
            SQLiteBBDD sqdb = new SQLiteBBDD();
            b = sqdb.loginC(login_edusuario.getText().toString(), login_edpassword.getText().toString());
            if(b) {
                Intent intent = new Intent(this, ListadoCoordinador.class);
                startActivity(intent);
            } else {
                b = sqdb.loginE(login_edusuario.getText().toString(), login_edpassword.getText().toString());
                if(b) {
                    Intent intent = new Intent(this, ListadoUsuario.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this,"Credenciales incorrectas",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
