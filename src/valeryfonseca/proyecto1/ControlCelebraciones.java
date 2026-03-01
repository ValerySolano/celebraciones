/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valeryfonseca.proyecto1;
import java.util.ArrayList;

/**
 *
 * @author Valery
 */
public class ControlCelebraciones {

    private ArrayList<Celebracion> lista = new ArrayList<>();
    private int nextId = 1;

    public ControlCelebraciones() {
    }
    public synchronized int reserveId() {
        return nextId++; 
    }
    public boolean addCelebracion(Celebracion c) {

        try {
            lista.add(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public ArrayList<Celebracion> getLista() {
        return lista;
    }
    public int cantidadCelebraciones() {
        return lista.size();
    }
    public String validarCelebracion(Celebracion c) {
        if (c.getPais() == null || c.getPais().isEmpty() || c.getPais().trim().isEmpty()) {
            return "El país no puede estar vacío";
        }
        if (c.getFecha() == null) {
            return "La fecha no puede estar vacía";
        }
        if (c.getDescripcion() == null || c.getDescripcion().isEmpty() || c.getDescripcion().trim().isEmpty()) {
            return "La descripción no puede estar vacía";
        }
        return null;
    }


    public ArrayList<String> getPaisesInvertidos() {
        ArrayList<String> paisesInvertidos = new ArrayList<>();
        ArrayList<String> paisesSinDuplicados = new ArrayList<>();
        for (Celebracion c : lista) {
            String pais = c.getPais();
            if (!paisesSinDuplicados.contains(pais)) {
                paisesSinDuplicados.add(pais);
                paisesInvertidos.add(invertirPais(pais));
            }
        }
        return paisesInvertidos;
    }
    // Invertir pais recursivamente
    public String invertirPais(String pais) {
        if (pais == null || pais.isEmpty()) {
            return pais;
        }
        return invertirPais(pais.substring(1)) + pais.charAt(0);
    }
}
