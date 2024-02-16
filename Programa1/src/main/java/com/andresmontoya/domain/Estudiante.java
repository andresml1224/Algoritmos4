package com.andresmontoya.domain;

public class Estudiante {
    private String nombre;
    private float [] notas = new float[5];
    private float promedio = 0;
    private Estudiante next = null;

    public Estudiante() {
        this.nombre = "";
        this.promedio = 0;
    }

    public Estudiante(String nombre, float[] notas, float promedio, Estudiante next) {
        this.nombre = nombre;
        this.notas = notas;
        this.promedio = calculoPromedio();
        this.next = next;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float[] getNotas() {
        return notas;
    }

    public void setNotas(float[] notas) {
        this.notas = notas;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public Estudiante getNext() {
        return next;
    }

    public void setNext(Estudiante next) {
        this.next = next;
    }

    public float calculoPromedio() {
        float suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        return suma / notas.length;
    }
}
