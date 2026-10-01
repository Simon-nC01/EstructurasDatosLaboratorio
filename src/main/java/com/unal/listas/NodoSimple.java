package com.unal.listas;

public class NodoSimple<T> {

    T dato;
    NodoSimple<T> siguiente;

    public NodoSimple(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}