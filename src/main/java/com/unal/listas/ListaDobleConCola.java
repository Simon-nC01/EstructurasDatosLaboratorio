package com.unal.listas;

public class ListaDobleConCola<T> {

    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int tamaño;

    public ListaDobleConCola() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }

    public void pushFront(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        nuevo.siguiente = cabeza;

        if (cabeza != null) {
            cabeza.anterior = nuevo;
        } else {
            cola = nuevo;
        }

        cabeza = nuevo;

        tamaño++;
    }

    public void pushBack(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        nuevo.anterior = cola;

        if (cola != null) {
            cola.siguiente = nuevo;
        } else {
            cabeza = nuevo;
        }

        cola = nuevo;

        tamaño++;
    }

    public T popFront() {
        if (cabeza == null) {
            return null;
        }

        T dato = cabeza.dato;

        cabeza = cabeza.siguiente;

        if (cabeza != null) {
            cabeza.anterior = null;
        } else {
            cola = null;
        }

        tamaño--;

        return dato;
    }

    public T popBack() {
        if (cola == null) {
            return null;
        }

        T dato = cola.dato;

        cola = cola.anterior;

        if (cola != null) {
            cola.siguiente = null;
        } else {
            cabeza = null;
        }

        tamaño--;

        return dato;
    }

    public T find(T dato) {
        NodoDoble<T> actual = cabeza;

        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return actual.dato;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    public boolean erase(T dato) {
        NodoDoble<T> actual = cabeza;

        while (actual != null) {
            if (actual.dato.equals(dato)) {

                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    cabeza = actual.siguiente;
                }

                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    cola = actual.anterior;
                }

                tamaño--;

                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public boolean addBefore(T referencia, T dato) {
        NodoDoble<T> actual = cabeza;

        while (actual != null) {
            if (actual.dato.equals(referencia)) {

                NodoDoble<T> nuevo = new NodoDoble<>(dato);

                nuevo.siguiente = actual;
                nuevo.anterior = actual.anterior;

                if (actual.anterior != null) {
                    actual.anterior.siguiente = nuevo;
                } else {
                    cabeza = nuevo;
                }

                actual.anterior = nuevo;

                tamaño++;

                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public boolean addAfter(T referencia, T dato) {
        NodoDoble<T> actual = cabeza;

        while (actual != null) {
            if (actual.dato.equals(referencia)) {

                NodoDoble<T> nuevo = new NodoDoble<>(dato);

                nuevo.anterior = actual;
                nuevo.siguiente = actual.siguiente;

                if (actual.siguiente != null) {
                    actual.siguiente.anterior = nuevo;
                } else {
                    cola = nuevo;
                }

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

        NodoDoble<T> actual = cabeza;

        while (actual != null) {
            resultado.append(actual.dato);

            if (actual.siguiente != null) {
                resultado.append(" <-> ");
            }

            actual = actual.siguiente;
        }

        return resultado.toString();
    }
}