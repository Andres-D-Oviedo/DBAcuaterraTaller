package com.sena.dbtalleracuaterra.models;

public class Sensor {
    private int id;
    private String tipo;
    private String dato;
    private String fecha;

    // Constructor
    public Sensor(String tipo, String dato, String fecha) {
        this.id = id;
        this.tipo = tipo;
        this.dato = dato;
        this.fecha = fecha;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDato() { return dato; }
    public void setDato(String dato) { this.dato = dato; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
