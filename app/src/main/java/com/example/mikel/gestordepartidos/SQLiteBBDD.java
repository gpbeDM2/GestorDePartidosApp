package com.example.mikel.gestordepartidos;


import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mikel on 14/05/2017.
 */

public class SQLiteBBDD extends Activity{
    private SQLiteHelper gest;
    private SQLiteDatabase db;

    public SQLiteBBDD(){}

    public void iniciar() {

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            db.beginTransaction();

            //Creamos el registro a insertar como objeto ContentValues
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("conencrip", "login");
            nuevoRegistro.put("nombre","coordinador");

            //Insertamos el registro en la base de datos
            db.insert("coordinador", null, nuevoRegistro);

            //Insertamos los datos en la tabla Usuarios
            db.rawQuery("INSERT INTO coordinador (nombre, conencrip) " +
                    "VALUES(coordinador, login)",null);
            db.setTransactionSuccessful();
            db.endTransaction();
            db.close();
            //Cerramos la base de datos
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Abrimos la base de datos 'gestor' en modo escritura
        gest = new SQLiteHelper(this, "gestor2", null, 1);

        db = gest.getWritableDatabase();
    }

    public boolean loginC(String name, String pass) {
        boolean b = false;
        //Abrimos la base de datos 'gestor' en modo escritura
        //gest = new SQLiteHelper(this, "gestor", null, 1);

        //db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos

        if (db != null) {
            Cursor c = db.rawQuery("SELECT nombre,conencrip FROM coordinador", null);
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
        //gest = new SQLiteHelper(this, "gestor", null, 1);

        //db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            Cursor c = db.rawQuery("SELECT nombre,conencrip FROM entrenador", null);
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

    public ArrayList<Partido> partidos(){
        ArrayList<Partido> p = new ArrayList<>();
        //Abrimos la base de datos 'gestor' en modo escritura
        //gest = new SQLiteHelper(this, "gestor", null, 1);

        //db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            Cursor c = db.rawQuery("SELECT equipo,arbitro,mesa,fecha FROM partido", null);
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    p.add(new Partido(c.getString(0),c.getString(1),c.getString(2),c.getString(3)));
                } while(c.moveToNext());
            } else {
                c.close();
                return null;
            }
            c.close();
        } else {
            return null;
        }
        return p;
    }

    public boolean editarPartidoA(String usuario, String equipo, String fecha){
        boolean b = false;
        //Abrimos la base de datos 'gestor' en modo escritura
        //gest = new SQLiteHelper(this, "gestor", null, 1);

        //db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            //Seleccionamos el id del entrenador
            String s = "SELECT id FROM entrenador WHERE nombre = " + usuario;
            Cursor c = db.rawQuery(s, null);
            if (c.moveToFirst()) {
                //Editamos el partido
                String id = c.getInt(0)+"";
                s = "UPDATE partido SET arbitro = '" + usuario +"' WHERE equipo = " + equipo + " AND fecha = " + fecha + ";";
                db.rawQuery(s, null);

                //Comprobamos la insercion.
                s = "SELECT * FROM partido WHERE arbitro = '" + usuario +"' AND equipo = " + equipo + " AND fecha = " + fecha + ";";
                Cursor c2 = db.rawQuery(s,null);
                if(c2.moveToFirst()){
                    c.close();
                    c2.close();
                    return true;
                } else {
                    c.close();
                    c2.close();
                    return false;
                }
            } else {
                c.close();
                Toast.makeText(this, "Error inesperado, lo sentimos", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return false;
    }

    public boolean editarPartidoM(String usuario, String equipo, String fecha){
        boolean b = false;
        //Abrimos la base de datos 'gestor' en modo escritura
        //gest = new SQLiteHelper(this, "gestor", null, 1);

        //db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            //Seleccionamos el id del entrenador
            String s = "SELECT id FROM entrenador WHERE nombre = " + usuario;
            Cursor c = db.rawQuery(s, null);
            if (c.moveToFirst()) {
                //Editamos el partido
                String id = c.getInt(0)+"";
                s = "UPDATE partido SET mesa = '" + usuario +"' WHERE equipo = " + equipo + " AND fecha = " + fecha + ";";
                db.rawQuery(s, null);

                //Comprobamos la insercion.
                s = "SELECT * FROM partido WHERE mesa = '" + usuario +"' AND equipo = " + equipo + " AND fecha = " + fecha + ";";
                Cursor c2 = db.rawQuery(s,null);
                if(c2.moveToFirst()){
                    c.close();
                    c2.close();
                    return true;
                } else {
                    c.close();
                    c2.close();
                    return false;
                }
            } else {
                c.close();
                Toast.makeText(this, "Error inesperado, lo sentimos", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return false;
    }

    public ArrayList<String> equipos(){
        ArrayList<String> e = new ArrayList<>();
        //Abrimos la base de datos 'gestor' en modo escritura
        //gest = new SQLiteHelper(this, "gestor", null, 1);

        //db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            Cursor c = db.rawQuery("SELECT nombre FROM equipo", null);
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    e.add(c.getString(0));
                } while(c.moveToNext());
            } else {
                c.close();
                return null;
            }
            c.close();
        } else {
            return null;
        }
        return e;
    }

    public boolean crearPartido(String equipo, String fecha) {
        //Abrimos la base de datos 'gestor' en modo escritura
        //gest = new SQLiteHelper(this, "gestor", null, 1);

        //db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            String s = "SELECT * FROM partido WHERE equipo = " + equipo + " AND fecha = " + fecha + ";";
            db.rawQuery(s, null);
            Cursor c = db.rawQuery(s,null);
            if(c.moveToFirst()){
                Toast.makeText(this, "El partido ya existe", Toast.LENGTH_SHORT).show();
            } else {
                s = "INSERT INTO partido (equipo, fecha) VALUES (" + equipo + "," + fecha +")";
                db.rawQuery(s, null);

                //Comprobamos la insercion.
                s = "SELECT * FROM partido WHERE equipo = " + equipo + " AND fecha = " + fecha + ";";
                Cursor c2 = db.rawQuery(s,null);
                if(c.moveToFirst()){
                    c.close();
                    c2.close();
                    return true;
                } else {
                    c.close();
                    c2.close();
                    return false;
                }
            }
        }
        return false;
    }

    public boolean crearEquipo(String nombre, int ent1, int ent2) {
        //Abrimos la base de datos 'gestor' en modo escritura
        //gest = new SQLiteHelper(this, "gestor", null, 1);

        //db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            String s = "SELECT * FROM equipo WHERE nombre = " + nombre + ";";
            db.rawQuery(s, null);
            Cursor c = db.rawQuery(s,null);
            if(c.moveToFirst()){
                Toast.makeText(this, "El equipo ya existe", Toast.LENGTH_SHORT).show();
            } else {
                s = "INSERT INTO equipo (nombre, entrenador1, entrenador2) VALUES (" + nombre + ",'" + ent1 + "','" + ent2 +"');";
                db.rawQuery(s, null);

                //Comprobamos la insercion.
                s = "SELECT * FROM equipo WHERE nombre = " + nombre + ";";
                Cursor c2 = db.rawQuery(s,null);
                if(c.moveToFirst()){
                    c.close();
                    c2.close();
                    return true;
                } else {
                    c.close();
                    c2.close();
                    return false;
                }
            }
        }
        return false;
    }

    public ArrayList<Entrenador> entrenadores() {
        ArrayList<Entrenador> e = new ArrayList<Entrenador>();

        //Abrimos la base de datos 'gestor' en modo escritura
        //gest = new SQLiteHelper(this, "gestor", null, 1);
        //db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            Cursor c = db.rawQuery("SELECT nombre,id FROM entrenador", null);
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    e.add(new Entrenador(c.getString(0),c.getInt(1)));
                } while(c.moveToNext());
            } else {
                c.close();
                return null;
            }
            c.close();
        } else {
            return null;
        }
        return e;
    }

    public boolean crearEntrenador(String nombre, String contrasena) {
        //Abrimos la base de datos 'gestor' en modo escritura
        //gest = new SQLiteHelper(this, "gestor", null, 1);
        //db = gest.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            String s = "SELECT * FROM entrenador WHERE nombre = " + nombre + ";";
            db.rawQuery(s, null);
            Cursor c = db.rawQuery(s,null);
            if(c.moveToFirst()){
                Toast.makeText(this, "El entrenador ya existe", Toast.LENGTH_SHORT).show();
            } else {
                s = "INSERT INTO entrenador (nombre, conencrip) VALUES (" + nombre + "," + contrasena + ");";
                db.rawQuery(s, null);

                //Comprobamos la insercion.
                s = "SELECT * FROM entrenador WHERE nombre = " + nombre + ";";
                Cursor c2 = db.rawQuery(s,null);
                if(c.moveToFirst()){
                    c.close();
                    c2.close();
                    return true;
                } else {
                    c.close();
                    c2.close();
                    return false;
                }
            }
        }
        return false;
    }
}
