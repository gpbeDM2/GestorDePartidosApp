package com.example.mikel.gestordepartidos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelper extends SQLiteOpenHelper {
    //Sentencia SQL para crear las tablas
    private String sqlCreateCo = "CREATE TABLE coordinador ("
                    + "id int(4) primary key auto_increment, "
                    + "nombre varchar(50) not null,"
                    + "con_encrip varchar(80) not null,"
                    + " tlf int(9))";

    private String sqlCreateEn  = "create table entrenador("
                        + "id int(4) primary key auto_increment,"
                        + "nombre varchar(50) not null,"
                        + "con_encrip varchar(80) not null,"
                        + "arbitraje int(2),"
                        + "mesa	int(2),"
                        + "tlf int(9));";

    private String sqlCreatePa  = "create table partido("
                        + "equipo varchar(50) not null,"
                        + "fecha varchar(50),"
                        + "arbitro int(4),"
                        + "mesa int(4),"
                        + "constraint PK_partido primary key (equipo,fecha))";

    private String sqlCreateEq  = "create table equipo("
                        + "nombre varchar(50) not null primary key,"
                        + "entrenador1 int(4) not null,"
                        + "entrenador2 int(4) not null)";

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
