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

    public void mergeSortDesc(ArrayList<Celebracion> lista, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            mergeSortDesc(lista, izquierda, medio);
            mergeSortDesc(lista, medio + 1, derecha);
            mergeDesc(lista, izquierda, medio, derecha);
        }
    }

    private void mergeDesc(ArrayList<Celebracion> lista, int izquierda, int medio, int derecha) {
        ArrayList<Celebracion> temp = new ArrayList<>(lista); // copia temporal
        int i = izquierda;
        int j = medio + 1;
        int k = izquierda;

        while (i <= medio && j <= derecha) {
            // Descendente: País Z→A, luego Fecha más reciente primero
            if (compararDesc(temp.get(i), temp.get(j)) <= 0) {
                lista.set(k, temp.get(i));
                i++;
            } else {
                lista.set(k, temp.get(j));
                j++;
            }
            k++;
        }

        while (i <= medio) {
            lista.set(k, temp.get(i));
            i++;
            k++;
        }

        while (j <= derecha) {
            lista.set(k, temp.get(j));
            j++;
            k++;
        }
    }

    private int compararDesc(Celebracion a, Celebracion b) {
        // País Z → A
        int compPais = b.getPais().compareToIgnoreCase(a.getPais());
        if (compPais != 0) {
            return compPais;
        }
        // Fecha más reciente primero
        return b.getFecha().compareTo(a.getFecha());
    }

    public ArrayList<Celebracion> buscarCelebracionesPorPais(String pais) {
        ArrayList<Celebracion> resultados = new ArrayList<>();
        for (Celebracion c : lista) {
            if (c.getPais().toLowerCase().contains(pais.toLowerCase())) {
                resultados.add(c);
            }
        }
        return resultados;
    }

    public boolean actualizarCelebracion(Celebracion celebracion) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == celebracion.getId()) {
                lista.set(i, celebracion);
                return true;
            }
        }
        return false;
    }
}
