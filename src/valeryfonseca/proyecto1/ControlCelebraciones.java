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
    private int nextId = 0;

    public ControlCelebraciones() {
    }

    public int reserveId() {
        this.nextId = this.lista.size() + 1;
        return this.nextId;
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

    public void algoritmoInsercion(ArrayList<Celebracion> lista) {

        for (int indice = 1; indice < lista.size(); indice++) {

            Celebracion actual = lista.get(indice);
            int auxiliar = indice - 1;

            while (auxiliar >= 0 && aplicarComparacion(actual, lista.get(auxiliar)) < 0) {
                lista.set(auxiliar + 1, lista.get(auxiliar));
                auxiliar--;
            }

            lista.set(auxiliar + 1, actual);
        }
    }

    private int aplicarComparacion(Celebracion a, Celebracion b) {
        // Comparar por país (ignorando mayúsculas/minúsculas)
        int compPais = a.getPais().compareToIgnoreCase(b.getPais());

        if (compPais != 0) { // Si los países son diferentes, devolver la comparación de los países
            return compPais;
        }
        return a.getFecha().compareTo(b.getFecha()); // Si los países son iguales, comparar por fecha
    }

    // 
    public ArrayList<Celebracion> mergeSortDesc(ArrayList<Celebracion> lista) {

        if (lista.size() <= 1) {
            return lista;
        }

        int mitad = lista.size() / 2;

        ArrayList<Celebracion> izquierda = new ArrayList<>(lista.subList(0, mitad));
        ArrayList<Celebracion> derecha = new ArrayList<>(lista.subList(mitad, lista.size()));

        izquierda = mergeSortDesc(izquierda);
        derecha = mergeSortDesc(derecha);

        return mergeDesc(izquierda, derecha);
    }

    private ArrayList<Celebracion> mergeDesc(
            ArrayList<Celebracion> izq,
            ArrayList<Celebracion> der) {

        ArrayList<Celebracion> resultado = new ArrayList<>();

        int i = 0, j = 0;

        while (i < izq.size() && j < der.size()) {

            Celebracion a = izq.get(i);
            Celebracion b = der.get(j);

            if (compararDesc(a, b) > 0) {
                resultado.add(a);
                i++;
            } else {
                resultado.add(b);
                j++;
            }
        }

        while (i < izq.size()) {
            resultado.add(izq.get(i++));
        }

        while (j < der.size()) {
            resultado.add(der.get(j++));
        }

        return resultado;
    }

    private int compararDesc(Celebracion a, Celebracion b) {

        // 1️⃣ País (Z → A)
        int compPais = b.getPais().compareToIgnoreCase(a.getPais());
        if (compPais != 0) {
            return compPais;
        }

        // 2️⃣ Fecha (más reciente primero)
        return b.getFecha().compareTo(a.getFecha());
    }
}
