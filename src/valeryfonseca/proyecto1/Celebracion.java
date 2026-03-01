/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valeryfonseca.proyecto1;

import java.util.Date;

/**
 *
 * @author Valery
 */
public class Celebracion {

    private int idCelebracion;
    private Date fecha;
    private String descripcion;
    private String pais;

    public Celebracion(int idCelebracion, Date fecha, String descripcion, String pais) {
        this.idCelebracion = idCelebracion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.pais = pais;
    }
    // Metodos set 

    public void setIdCelebracion(int idCelebracion) {
        this.idCelebracion = idCelebracion;
    }

    public void setFecha(Date fecha) {
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

    public int getId() {
        return idCelebracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPais() {
        return pais;
    }

}
