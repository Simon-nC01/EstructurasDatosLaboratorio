package com.unal.listas;

public class ListaDoble<T> {

    private NodoDoble<T> cabeza;
    private int tamaño;

    public ListaDoble() {
        cabeza = null;
        tamaño = 0;
    }

    public void pushFront(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        nuevo.siguiente = cabeza;

        if (cabeza != null) {
            cabeza.anterior = nuevo;
        }

        cabeza = nuevo;

        tamaño++;
    }

    public void pushBack(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            tamaño++;
            return;
        }

        NodoDoble<T> actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
        nuevo.anterior = actual;

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
        }

        tamaño--;

        return dato;
    }

    public T popBack() {
        if (cabeza == null) {
            return null;
        }

        NodoDoble<T> actual = cabeza;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }

        T dato = actual.dato;

        if (actual.anterior == null) {
            cabeza = null;
        } else {
            actual.anterior.siguiente = null;
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

                if (actual.anterior == null) {
                    cabeza = actual.siguiente;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                }

                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
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
        if (cabeza == null) {
            return null;
        }

        NodoDoble<T> actual = cabeza;

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