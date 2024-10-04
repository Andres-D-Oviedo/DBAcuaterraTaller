package com.sena.dbtalleracuaterra.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sena.dbtalleracuaterra.models.Modulo;
import com.sena.dbtalleracuaterra.models.Sensor;
import com.sena.dbtalleracuaterra.models.Usuario;

import java.util.ArrayList;

public class ManagerDB {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public ManagerDB(Context context) {
        dbHelper = new DbHelper(context); // Instancia de la base de datos
    }

    // Abrir la base de datos en modo escritura
    public void openDbWritable() {
        db = dbHelper.getWritableDatabase();
    }

    // Abrir la base de datos en modo lectura
    public void openDbReadable() {
        db = dbHelper.getReadableDatabase();
    }

    // Cerrar la base de datos
    public void closeDb() {
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    // **Usuario CRUD**

    // Insertar un usuario
    public void insertarUsuario(Usuario usuario) {
        openDbWritable();
        ContentValues values = new ContentValues();
        values.put(Constantes.USUARIO_NOMBRE, usuario.getNombre());
        values.put(Constantes.USUARIO_EMAIL, usuario.getEmail());
        values.put(Constantes.USUARIO_CELULAR, usuario.getCelular());
        values.put(Constantes.USUARIO_FECHA_NAC, usuario.getFechaNacimiento());
        values.put(Constantes.USUARIO_ROL, usuario.getRol());
        long result = db.insert(Constantes.TABLA_USUARIO, null, values);
    }

    // Listar usuarios
    public ArrayList<Usuario> listarUsuarios() {
        openDbReadable();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.TABLA_USUARIO, null);
        if (cursor.moveToFirst()) {
            do {
                Usuario usuario = new Usuario(
                        // id
                        cursor.getString(1), // nombre
                        cursor.getString(2), // email
                        cursor.getString(3), // celular
                        cursor.getString(4), // fechaNacimiento
                        cursor.getString(5)  // rol
                );
                usuarios.add(usuario);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return usuarios;
    }

    // Actualizar usuario
    public int actualizarUsuario(Usuario usuario) {
        openDbWritable();
        ContentValues values = new ContentValues();
        values.put(Constantes.USUARIO_NOMBRE, usuario.getNombre());
        values.put(Constantes.USUARIO_EMAIL, usuario.getEmail());
        values.put(Constantes.USUARIO_CELULAR, usuario.getCelular());
        values.put(Constantes.USUARIO_FECHA_NAC, usuario.getFechaNacimiento());
        values.put(Constantes.USUARIO_ROL, usuario.getRol());
        int result = db.update(Constantes.TABLA_USUARIO, values, Constantes.USUARIO_ID + "=?", new String[]{String.valueOf(usuario.getId())});
        return result;
    }

    // Eliminar usuario
    public int eliminarUsuario(Usuario usuario) {
        openDbWritable();
        int result = db.delete(Constantes.TABLA_USUARIO, Constantes.USUARIO_ID + "=?", new String[]{String.valueOf(usuario.getId())});
        return result;
    }

    // Métodos CRUD para Sensores y Modulo serían similares, solo cambiando los nombres de los campos y tablas
    // Insertar un sensor
    public long insertarSensor(Sensor sensor) {
        openDbWritable();
        ContentValues values = new ContentValues();
        values.put(Constantes.SENSOR_TIPO, sensor.getTipo());
        values.put(Constantes.SENSOR_DATO, sensor.getDato());
        values.put(Constantes.SENSOR_FECHA, sensor.getFecha());
        long result = db.insert(Constantes.TABLA_SENSORES, null, values);
        return result;
    }

    // Listar sensores
    public ArrayList<String> listarSensores() {
        openDbReadable();
        ArrayList<String> sensores = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.TABLA_SENSORES, null);
        if (cursor.moveToFirst()) {
            do {
                sensores.add("ID: " + cursor.getInt(0) + " - Tipo: " + cursor.getString(1) + " - Dato: " + cursor.getString(2));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return sensores;
    }

    // Actualizar sensor
    public int actualizarSensor(Sensor sensor) {
        openDbWritable();
        ContentValues values = new ContentValues();
        values.put(Constantes.SENSOR_TIPO, sensor.getTipo());
        values.put(Constantes.SENSOR_DATO, sensor.getDato());
        values.put(Constantes.SENSOR_FECHA, sensor.getFecha());
        int result = db.update(Constantes.TABLA_SENSORES, values, Constantes.SENSORES_ID + "=?", new String[]{String.valueOf(sensor.getId())});
        return result;
    }

    // Eliminar sensor
    public int eliminarSensor(Sensor sensor) {
        openDbWritable();
        int result = db.delete(Constantes.TABLA_SENSORES, Constantes.SENSORES_ID + "=?", new String[]{String.valueOf(sensor.getId())});
        return result;
    }

    // Insertar un módulo
    public long insertarModulo(Modulo modulo) {
        openDbWritable();
        ContentValues values = new ContentValues();
        values.put(Constantes.MODULO_VOLUMEN, modulo.getVolumen());
        values.put(Constantes.MODULO_NUM_PECES, modulo.getNumPeces());
        values.put(Constantes.MODULO_ESPECIE_PECES, modulo.getEspeciePeces());
        values.put(Constantes.MODULO_NUM_PLANTAS, modulo.getNumPlantas());
        values.put(Constantes.MODULO_ESPECIE_PLANTAS, modulo.getEspeciePlantas());
        long result = db.insert(Constantes.TABLA_MODULO, null, values);
        return result;
    }

    // Listar módulos
    public ArrayList<String> listarModulos() {
        openDbReadable();
        ArrayList<String> modulos = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.TABLA_MODULO, null);
        if (cursor.moveToFirst()) {
            do {
                modulos.add("ID: " + cursor.getInt(0) + " - Volumen: " + cursor.getString(1) + " - Peces: " + cursor.getInt(2));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return modulos;
    }

    // Actualizar módulo
    public int actualizarModulo(Modulo modulo) {
        openDbWritable();
        ContentValues values = new ContentValues();
        values.put(Constantes.MODULO_VOLUMEN, modulo.getVolumen());
        values.put(Constantes.MODULO_NUM_PECES, modulo.getNumPeces());
        values.put(Constantes.MODULO_ESPECIE_PECES, modulo.getEspeciePeces());
        values.put(Constantes.MODULO_NUM_PLANTAS, modulo.getNumPlantas());
        values.put(Constantes.MODULO_ESPECIE_PLANTAS, modulo.getEspeciePlantas());
        int result = db.update(Constantes.TABLA_MODULO, values, Constantes.MODULO_ID + "=?", new String[]{String.valueOf(modulo.getId())});
        return result;
    }

    // Eliminar módulo
    public int eliminarModulo(Modulo modulo) {
        openDbWritable();
        int result = db.delete(Constantes.TABLA_MODULO, Constantes.MODULO_ID + "=?", new String[]{String.valueOf(modulo.getId())});
        return result;
    }
}