package com.unal.colas;

public class ColaArregloCircular<T> implements MyQueue<T> {

    private T[] datos;
    private int frente;
    private int tamaño;

    private static final int CAPACIDAD_INICIAL = 4;

    @SuppressWarnings("unchecked")
    public ColaArregloCircular() {
        datos = (T[]) new Object[CAPACIDAD_INICIAL];
        frente = 0;
        tamaño = 0;
    }

    @Override
    public void enqueue(T x) {

        if (tamaño == datos.length) {
            aumentarCapacidad();
        }

        int posicion = (frente + tamaño) % datos.length;

        datos[posicion] = x;

        tamaño++;
    }

    @Override
    public T dequeue() {

        if (isEmpty()) {
            return null;
        }

        T dato = datos[frente];

        datos[frente] = null;

        frente = (frente + 1) % datos.length;

        tamaño--;

        if (tamaño == 0) {
            frente = 0;
        }

        return dato;
    }

    @Override
    public T front() {

        if (isEmpty()) {
            return null;
        }

        return datos[frente];
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

        if (isEmpty()) {
            return false;
        }

        int posicion = frente;

        for (int i = 0; i < tamaño; i++) {

            if (datos[posicion].equals(n)) {

                for (int j = i; j < tamaño - 1; j++) {

                    int actual = (frente + j) % datos.length;
                    int siguiente = (frente + j + 1) % datos.length;

                    datos[actual] = datos[siguiente];
                }

                int ultimaPosicion =
                        (frente + tamaño - 1) % datos.length;

                datos[ultimaPosicion] = null;

                tamaño--;

                return true;
            }

            posicion = (posicion + 1) % datos.length;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    private void aumentarCapacidad() {

        int nuevaCapacidad = datos.length * 2;

        T[] nuevoArreglo = (T[]) new Object[nuevaCapacidad];

        for (int i = 0; i < tamaño; i++) {

            int posicionActual =
                    (frente + i) % datos.length;

            nuevoArreglo[i] = datos[posicionActual];
        }

        datos = nuevoArreglo;

        frente = 0;
    }

    @Override
    public String toString() {

        StringBuilder resultado = new StringBuilder();

        resultado.append("[");

        for (int i = 0; i < tamaño; i++) {

            int posicion =
                    (frente + i) % datos.length;

            resultado.append(datos[posicion]);

            if (i < tamaño - 1) {
                resultado.append(", ");
            }
        }

        resultado.append("]");

        return resultado.toString();
    }
}