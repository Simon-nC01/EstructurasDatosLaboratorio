package com.unal.listas;

public class ListaSimple<T> {

    private NodoSimple<T> cabeza;
    private int tamaño;

    public ListaSimple() {
        cabeza = null;
        tamaño = 0;
    }

    public void pushFront(T dato) {
        NodoSimple<T> nuevo = new NodoSimple<>(dato);

        nuevo.siguiente = cabeza;
        cabeza = nuevo;

        tamaño++;
    }

    public void pushBack(T dato) {
        NodoSimple<T> nuevo = new NodoSimple<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoSimple<T> actual = cabeza;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }

        tamaño++;
    }

    public T popFront() {
        if (cabeza == null) {
            return null;
        }

        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;

        tamaño--;

        return dato;
    }

    public T popBack() {
        if (cabeza == null) {
            return null;
        }

        if (cabeza.siguiente == null) {
            T dato = cabeza.dato;
            cabeza = null;
            tamaño--;
            return dato;
        }

        NodoSimple<T> actual = cabeza;

        while (actual.siguiente.siguiente != null) {
            actual = actual.siguiente;
        }

        T dato = actual.siguiente.dato;
        actual.siguiente = null;

        tamaño--;

        return dato;
    }

    public T find(T dato) {
        NodoSimple<T> actual = cabeza;

        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return actual.dato;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    public boolean erase(T dato) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            tamaño--;
            return true;
        }

        NodoSimple<T> actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.siguiente.dato.equals(dato)) {
                actual.siguiente = actual.siguiente.siguiente;
                tamaño--;
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public boolean addBefore(T referencia, T dato) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.dato.equals(referencia)) {
            pushFront(dato);
            return true;
        }

        NodoSimple<T> actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.siguiente.dato.equals(referencia)) {
                NodoSimple<T> nuevo = new NodoSimple<>(dato);

                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;

                tamaño++;
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public boolean addAfter(T referencia, T dato) {
        NodoSimple<T> actual = cabeza;

        while (actual != null) {
            if (actual.dato.equals(referencia)) {
                NodoSimple<T> nuevo = new NodoSimple<>(dato);

                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;

                tamaño++;
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public int size() {
        return tamaño;
    }

    public T front() {
        if (cabeza == null) {
            return null;
        }

        return cabeza.dato;
    }

    public T back() {
        if (cabeza == null) {
            return null;
        }

        NodoSimple<T> actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        return actual.dato;
    }

    public void clear() {
        cabeza = null;
        tamaño = 0;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        NodoSimple<T> actual = cabeza;

        while (actual != null) {
            resultado.append(actual.dato);

            if (actual.siguiente != null) {
                resultado.append(" -> ");
            }

            actual = actual.siguiente;
        }

        return resultado.toString();
    }
}