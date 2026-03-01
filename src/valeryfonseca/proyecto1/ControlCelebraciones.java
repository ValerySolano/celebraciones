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
}
