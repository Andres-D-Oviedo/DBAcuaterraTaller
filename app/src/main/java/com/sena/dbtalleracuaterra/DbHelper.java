package com.sena.dbtalleracuaterra;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Esta clase gestionará la creación y actualización de la base de datos.
public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, Constantes.NOM_BD, null, Constantes.VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear las tablas cuando se crea la base de datos
        db.execSQL(Constantes.CREAR_TABLA_USUARIO);
        db.execSQL(Constantes.CREAR_TABLA_SENSORES);
        db.execSQL(Constantes.CREAR_TABLA_MODULO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Actualizar la base de datos (en este caso, simplemente eliminar y volver a crear las tablas)
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_SENSORES);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_MODULO);
        onCreate(db);
    }
}