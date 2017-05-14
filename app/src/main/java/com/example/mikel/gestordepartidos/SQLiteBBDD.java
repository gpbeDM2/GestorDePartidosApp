package com.example.mikel.gestordepartidos;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mikel on 14/05/2017.
 */

public class SQLiteBBDD extends Activity{
    private SQLiteHelper gest;
    private SQLiteDatabase db;

    public SQLiteBBDD(){}
    public void iniciar() {
        //Abrimos la base de datos 'gestor' en modo escritura
        gest = new SQLiteHelper(this, "gestor", null, 1);

        db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            //Insertamos los datos en la tabla Usuarios
            db.execSQL("INSERT INTO coordinador (nombre, con_encrip) " +
                        "VALUES (coordinador, login)");

            //Cerramos la base de datos
            db.close();
        }
    }

    public boolean loginC(String name, String pass) {
        boolean b = false;
        //Abrimos la base de datos 'gestor' en modo escritura
        gest = new SQLiteHelper(this, "gestor", null, 1);

        db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            Cursor c = db.rawQuery("SELECT nombre,con_encrip FROM coordinador", null);
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    String nombre       = c.getString(0);
                    String con_encrip   = c.getString(1);
                    if(nombre.equals(name) && con_encrip.equals(pass)){
                        b = true;
                    }
                } while(c.moveToNext());
            }
            c.close();
        }
        return b;
    }

    public boolean loginE(String name, String pass) {
        boolean b = false;
        //Abrimos la base de datos 'gestor' en modo escritura
        gest = new SQLiteHelper(this, "gestor", null, 1);

        db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            Cursor c = db.rawQuery("SELECT nombre,con_encrip FROM entrenador", null);
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    String nombre       = c.getString(0);
                    String con_encrip   = c.getString(1);
                    if(nombre.equals(name) && con_encrip.equals(pass)){
                        b = true;
                    }
                } while(c.moveToNext());
            }
            c.close();
        }
        return b;
    }
}
