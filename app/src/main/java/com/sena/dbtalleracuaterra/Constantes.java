package com.sena.dbtalleracuaterra;

//Esta clase contendrá los nombres de la base de datos, tablas, y columnas.
public class Constantes {

    // Nombre de la base de datos
    public static final String NOM_BD = "DbProyectoIoT";
    public static final int VERSION_BD = 1;

    // Tabla Usuario
    public static final String TABLA_USUARIO = "Usuario";
    public static final String USUARIO_ID = "id";
    public static final String USUARIO_NOMBRE = "nombre";
    public static final String USUARIO_EMAIL = "email";
    public static final String USUARIO_CELULAR = "celular";
    public static final String USUARIO_FECHA_NAC = "fecha_nacimiento";
    public static final String USUARIO_ROL = "rol";

    // Tabla Sensores
    public static final String TABLA_SENSORES = "Sensores";
    public static final String SENSORES_ID = "id";
    public static final String SENSOR_TIPO = "tipo_sensor";
    public static final String SENSOR_DATO = "dato";
    public static final String SENSOR_FECHA = "fecha";

    // Tabla Modulo
    public static final String TABLA_MODULO = "Modulo";
    public static final String MODULO_ID = "id";
    public static final String MODULO_VOLUMEN = "volumen";
    public static final String MODULO_NUM_PECES = "num_peces";
    public static final String MODULO_ESPECIE_PECES = "especie_peces";
    public static final String MODULO_NUM_PLANTAS = "num_plantas";
    public static final String MODULO_ESPECIE_PLANTAS = "especie_plantas";

    // Creación de tablas SQL
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO + "(" +
            USUARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            USUARIO_NOMBRE + " TEXT NOT NULL, " +
            USUARIO_EMAIL + " TEXT NOT NULL, " +
            USUARIO_CELULAR + " TEXT, " +
            USUARIO_FECHA_NAC + " TEXT, " +
            USUARIO_ROL + " TEXT)";

    public static final String CREAR_TABLA_SENSORES = "CREATE TABLE " + TABLA_SENSORES + "(" +
            SENSORES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SENSOR_TIPO + " TEXT NOT NULL, " +
            SENSOR_DATO + " TEXT NOT NULL, " +
            SENSOR_FECHA + " TEXT NOT NULL)";

    public static final String CREAR_TABLA_MODULO = "CREATE TABLE " + TABLA_MODULO + "(" +
            MODULO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            MODULO_VOLUMEN + " TEXT NOT NULL, " +
            MODULO_NUM_PECES + " INTEGER NOT NULL, " +
            MODULO_ESPECIE_PECES + " TEXT, " +
            MODULO_NUM_PLANTAS + " INTEGER, " +
            MODULO_ESPECIE_PLANTAS + " TEXT)";


}
