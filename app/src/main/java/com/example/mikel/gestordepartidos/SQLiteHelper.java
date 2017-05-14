package com.example.mikel.gestordepartidos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelper extends SQLiteOpenHelper {
    //Sentencia SQL para crear las tablas
    private String sqlCreateCo = "CREATE TABLE coordinador("
                    + "id INTEGER primary key AUTOINCREMENT, "
                    + "nombre TEXT not null, "
                    + "conencrip TEXT not null, "
                    + "tlf INTEGER)";

    private String sqlCreateEn  = "create table entrenador("
                        + "id INTEGER primary key AUTOINCREMENT, "
                        + "nombre TEXT not null, "
                        + "conencrip TEXT not null, "
                        + "arbitraje INTEGER, "
                        + "mesa	INTEGER, "
                        + "tlf INTEGER)";

    private String sqlCreatePa  = "create table partido("
                        + "equipo TEXT not null, "
                        + "fecha TEXT, "
                        + "arbitro INTEGER, "
                        + "mesa INTEGER, "
                        + "primary key (equipo,fecha))";

    private String sqlCreateEq  = "create table equipo("
                        + "nombre TEXT not null primary key, "
                        + "entrenador1 INTEGER not null, "
                        + "entrenador2 INTEGER not null)";

    public SQLiteHelper(Context contexto, String nombre,
                        SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreateCo);
        db.execSQL(sqlCreateEn);
        db.execSQL(sqlCreatePa);
        db.execSQL(sqlCreateEq);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //Se elimina la versión anterior de las tablas
        db.execSQL("DROP TABLE IF EXISTS coordinador");
        db.execSQL("DROP TABLE IF EXISTS entrenador");
        db.execSQL("DROP TABLE IF EXISTS partido");
        db.execSQL("DROP TABLE IF EXISTS equipo");

        //Se crea la nueva versión de las tablas
        db.execSQL(sqlCreateCo);
        db.execSQL(sqlCreateEn);
        db.execSQL(sqlCreatePa);
        db.execSQL(sqlCreateEq);
    }
}
