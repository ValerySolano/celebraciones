/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valeryfonseca.proyecto1;

import java.time.LocalDate;

/**
 *
 * @author Valery
 */
public class Celebracion {

    private int idCelebracion;
    private LocalDate fecha;
    private String descripcion;
    private String pais;
    
    public Celebracion(int idCelebracion, LocalDate fecha, String descripcion, String pais) {
        this.idCelebracion = idCelebracion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.pais = pais;
    }
    // Metodos set 

    public void setIdCelebracion(int idCelebracion) {
        this.idCelebracion = idCelebracion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    // Metodos get
    public int getIdCelebracion() {
        return idCelebracion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPais() {
        return pais;
    }
    
}
