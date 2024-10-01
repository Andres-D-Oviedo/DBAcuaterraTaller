package com.sena.dbtalleracuaterra;

public class Modulo {
    private int id;
    private String volumen;
    private int numPeces;
    private String especiePeces;
    private int numPlantas;
    private String especiePlantas;

    // Constructor
    public Modulo(int id, String volumen, int numPeces, String especiePeces, int numPlantas, String especiePlantas) {
        this.id = id;
        this.volumen = volumen;
        this.numPeces = numPeces;
        this.especiePeces = especiePeces;
        this.numPlantas = numPlantas;
        this.especiePlantas = especiePlantas;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getVolumen() { return volumen; }
    public void setVolumen(String volumen) { this.volumen = volumen; }

    public int getNumPeces() { return numPeces; }
    public void setNumPeces(int numPeces) { this.numPeces = numPeces; }

    public String getEspeciePeces() { return especiePeces; }
    public void setEspeciePeces(String especiePeces) { this.especiePeces = especiePeces; }

    public int getNumPlantas() { return numPlantas; }
    public void setNumPlantas(int numPlantas) { this.numPlantas = numPlantas; }

    public String getEspeciePlantas() { return especiePlantas; }
    public void setEspeciePlantas(String especiePlantas) { this.especiePlantas = especiePlantas; }
}
