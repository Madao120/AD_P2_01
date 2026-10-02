package org.example;

import java.sql.Date;

// Representa un registro de la tabla "anime".
public class Anime {

    // Estos atributos corresponden a las columnas de la tabla.
    private String nome;
    private String descripcion;
    private Date data;
    private int puntuacion;

    // Constructor para crear un Anime con sus datos.
    public Anime(String nome, String descripcion, Date data, int puntuacion) {
        this.nome = nome;
        this.descripcion = descripcion;
        this.data = data;
        this.puntuacion = puntuacion;
    }

    // Getters y setters para acceder y modificar los atributos.
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
