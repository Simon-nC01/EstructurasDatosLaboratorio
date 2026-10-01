package com.unal.listas;

public class ListaSimpleConCola<T> {

    private NodoSimple<T> cabeza;
    private NodoSimple<T> cola;
    private int tamaño;

    public ListaSimpleConCola() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }

    public void pushFront(T dato) {
        NodoSimple<T> nuevo = new NodoSimple<>(dato);

        nuevo.siguiente = cabeza;
        cabeza = nuevo;

        if (cola == null) {
            cola = nuevo;
        }

        tamaño++;
    }

    public void pushBack(T dato) {
        NodoSimple<T> nuevo = new NodoSimple<>(dato);

        if (cola == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }

        tamaño++;
    }

    public T popFront() {
        if (cabeza == null) {
            return null;
        }

        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;

        if (cabeza == null) {
            cola = null;
        }

        tamaño--;

        return dato;
    }

    public T popBack() {
        if (cabeza == null) {
            return null;
        }

        if (cabeza == cola) {
            T dato = cabeza.dato;

            cabeza = null;
            cola = null;
            tamaño--;

            return dato;
        }

        NodoSimple<T> actual = cabeza;

        while (actual.siguiente != cola) {
            actual = actual.siguiente;
        }

        T dato = cola.dato;

        cola = actual;
        cola.siguiente = null;

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
            popFront();
            return true;
        }

        NodoSimple<T> actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.siguiente.dato.equals(dato)) {

                if (actual.siguiente == cola) {
                    cola = actual;
                }

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

                if (actual == cola) {
                    cola = nuevo;
                }

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
        if (cola == null) {
            return null;
        }

        return cola.dato;
    }

    public void clear() {
        cabeza = null;
        cola = null;
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
