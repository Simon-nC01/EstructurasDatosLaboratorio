package com.unal.pilas;

public class PilaArregloDinamico<T> implements MyStack<T> {

    private T[] datos;
    private int tamaño;

    private static final int CAPACIDAD_INICIAL = 4;

    @SuppressWarnings("unchecked")
    public PilaArregloDinamico() {
        datos = (T[]) new Object[CAPACIDAD_INICIAL];
        tamaño = 0;
    }

    @Override
    public void push(T x) {

        if (tamaño == datos.length) {
            aumentarCapacidad();
        }

        datos[tamaño] = x;
        tamaño++;
    }

    @Override
    public T pop() {

        if (isEmpty()) {
            return null;
        }

        tamaño--;

        T dato = datos[tamaño];

        datos[tamaño] = null;

        return dato;
    }

    @Override
    public T peek() {

        if (isEmpty()) {
            return null;
        }

        return datos[tamaño - 1];
    }

    @Override
    public boolean isEmpty() {
        return tamaño == 0;
    }

    @Override
    public int size() {
        return tamaño;
    }

    @Override
    public boolean delete(T n) {

        for (int i = 0; i < tamaño; i++) {

            if (datos[i].equals(n)) {

                for (int j = i; j < tamaño - 1; j++) {
                    datos[j] = datos[j + 1];
                }

                tamaño--;

                datos[tamaño] = null;

                return true;
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    private void aumentarCapacidad() {

        int nuevaCapacidad = datos.length * 2;

        T[] nuevoArreglo = (T[]) new Object[nuevaCapacidad];

        for (int i = 0; i < tamaño; i++) {
            nuevoArreglo[i] = datos[i];
        }

        datos = nuevoArreglo;
    }

    
    public void clear() {
        for (int i = 0; i < tamaño; i++) {
            datos[i] = null;
        }
        
        tamaño = 0;
    }
    
    
    
    @Override
    public String toString() {

        StringBuilder resultado = new StringBuilder();

        resultado.append("[");

        for (int i = 0; i < tamaño; i++) {

            resultado.append(datos[i]);

            if (i < tamaño - 1) {
                resultado.append(", ");
            }
        }

        resultado.append("]");

        return resultado.toString();
    }
}