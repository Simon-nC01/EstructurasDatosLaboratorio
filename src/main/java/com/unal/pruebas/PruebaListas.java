package com.unal.pruebas;

import com.unal.listas.ListaSimple;
import com.unal.listas.ListaSimpleConCola;
import com.unal.listas.ListaDoble;
import com.unal.listas.ListaDobleConCola;

public class PruebaListas {

    public static void main(String[] args) {

        probarListaSimple();
        probarListaSimpleConCola();
        probarListaDoble();
        probarListaDobleConCola();

    }

    private static void probarListaSimple() {

        System.out.println("\n===== LISTA SIMPLE =====");

        ListaSimple<Integer> lista = new ListaSimple<>();

        // CASO 1: lista vacía
        System.out.println("\nCaso 1: lista vacía");

        System.out.println("popFront(): " + lista.popFront());
        System.out.println("popBack(): " + lista.popBack());
        System.out.println("find(10): " + lista.find(10));
        System.out.println("erase(10): " + lista.erase(10));

        // CASO 2: un solo elemento
        System.out.println("\nCaso 2: un solo elemento");

        lista.pushBack(10);

        System.out.println("Lista: " + lista);
        System.out.println("popFront(): " + lista.popFront());
        System.out.println("Lista después: " + lista);
        System.out.println("¿Vacía?: " + lista.isEmpty());

        lista.pushBack(10);

        System.out.println("popBack(): " + lista.popBack());
        System.out.println("Lista después: " + lista);
        System.out.println("¿Vacía?: " + lista.isEmpty());

        // CASO 3: addBefore al primero
        System.out.println("\nCaso 3: addBefore al primero");

        lista.pushBack(10);
        lista.pushBack(20);
        lista.pushBack(30);

        lista.addBefore(10, 5);

        System.out.println("Resultado: " + lista);

        // CASO 4: addAfter al último
        System.out.println("\nCaso 4: addAfter al último");

        lista.addAfter(30, 40);

        System.out.println("Resultado: " + lista);

        // CASO 5: borrar primero, medio y último
        System.out.println("\nCaso 5: erase");

        lista.erase(5);
        System.out.println("Después de borrar primero: " + lista);

        lista.erase(20);
        System.out.println("Después de borrar medio: " + lista);

        lista.erase(40);
        System.out.println("Después de borrar último: " + lista);

        System.out.println("¿Tamaño correcto? " + (lista.size() == 2));

        // Vaciar completamente
        lista.clear();

        System.out.println("\nDespués de clear:");
        System.out.println("Lista: " + lista);
        System.out.println("¿Vacía?: " + lista.isEmpty());
        System.out.println("Tamaño: " + lista.size());
    }

    private static void probarListaSimpleConCola() {

        System.out.println("\n\n===== LISTA SIMPLE CON COLA =====");

        ListaSimpleConCola<Integer> lista = new ListaSimpleConCola<>();

        // Lista vacía
        System.out.println("\nCaso 1: lista vacía");

        System.out.println("popFront(): " + lista.popFront());
        System.out.println("popBack(): " + lista.popBack());
        System.out.println("find(10): " + lista.find(10));
        System.out.println("erase(10): " + lista.erase(10));

        // Un elemento
        System.out.println("\nCaso 2: un solo elemento");

        lista.pushBack(10);

        System.out.println("Lista: " + lista);
        System.out.println("Front: " + lista.front());
        System.out.println("Back: " + lista.back());

        System.out.println("popFront(): " + lista.popFront());

        System.out.println("Lista: " + lista);
        System.out.println("¿Vacía?: " + lista.isEmpty());
        System.out.println("Back: " + lista.back());

        lista.pushBack(10);

        System.out.println("popBack(): " + lista.popBack());

        System.out.println("Lista: " + lista);
        System.out.println("¿Vacía?: " + lista.isEmpty());
        System.out.println("Front: " + lista.front());
        System.out.println("Back: " + lista.back());

        // addBefore al primero
        System.out.println("\nCaso 3: addBefore al primero");

        lista.pushBack(10);
        lista.pushBack(20);
        lista.pushBack(30);

        lista.addBefore(10, 5);

        System.out.println("Resultado: " + lista);
        System.out.println("Front: " + lista.front());
        System.out.println("Back: " + lista.back());

        // addAfter al último
        System.out.println("\nCaso 4: addAfter al último");

        lista.addAfter(30, 40);

        System.out.println("Resultado: " + lista);
        System.out.println("Front: " + lista.front());
        System.out.println("Back: " + lista.back());

        // erase
        System.out.println("\nCaso 5: erase");

        lista.erase(5);
        System.out.println("Después de borrar primero: " + lista);

        lista.erase(20);
        System.out.println("Después de borrar medio: " + lista);

        lista.erase(40);
        System.out.println("Después de borrar último: " + lista);

        System.out.println("Front: " + lista.front());
        System.out.println("Back: " + lista.back());

        lista.clear();

        System.out.println("\nDespués de clear:");
        System.out.println("Lista: " + lista);
        System.out.println("¿Vacía?: " + lista.isEmpty());
        System.out.println("Front: " + lista.front());
        System.out.println("Back: " + lista.back());
    }

    private static void probarListaDoble() {

        System.out.println("\n\n===== LISTA DOBLE =====");

        ListaDoble<Integer> lista = new ListaDoble<>();

        // Lista vacía
        System.out.println("\nCaso 1: lista vacía");

        System.out.println("popFront(): " + lista.popFront());
        System.out.println("popBack(): " + lista.popBack());
        System.out.println("find(10): " + lista.find(10));
        System.out.println("erase(10): " + lista.erase(10));

        // Un elemento
        System.out.println("\nCaso 2: un solo elemento");

        lista.pushBack(10);

        System.out.println("Lista: " + lista);
        System.out.println("popFront(): " + lista.popFront());
        System.out.println("¿Vacía?: " + lista.isEmpty());

        lista.pushBack(10);

        System.out.println("popBack(): " + lista.popBack());
        System.out.println("¿Vacía?: " + lista.isEmpty());

        // addBefore
        System.out.println("\nCaso 3: addBefore al primero");

        lista.pushBack(10);
        lista.pushBack(20);
        lista.pushBack(30);

        lista.addBefore(10, 5);

        System.out.println("Resultado: " + lista);

        // addAfter
        System.out.println("\nCaso 4: addAfter al último");

        lista.addAfter(30, 40);

        System.out.println("Resultado: " + lista);

        // erase
        System.out.println("\nCaso 5: erase");

        lista.erase(5);
        System.out.println("Después de borrar primero: " + lista);

        lista.erase(20);
        System.out.println("Después de borrar medio: " + lista);

        lista.erase(40);
        System.out.println("Después de borrar último: " + lista);

        lista.clear();

        System.out.println("\nDespués de clear:");
        System.out.println("Lista: " + lista);
        System.out.println("¿Vacía?: " + lista.isEmpty());
        System.out.println("Tamaño: " + lista.size());
    }

    private static void probarListaDobleConCola() {

        System.out.println("\n\n===== LISTA DOBLE CON COLA =====");

        ListaDobleConCola<Integer> lista = new ListaDobleConCola<>();

        // Lista vacía
        System.out.println("\nCaso 1: lista vacía");

        System.out.println("popFront(): " + lista.popFront());
        System.out.println("popBack(): " + lista.popBack());
        System.out.println("find(10): " + lista.find(10));
        System.out.println("erase(10): " + lista.erase(10));

        // Un elemento
        System.out.println("\nCaso 2: un solo elemento");

        lista.pushBack(10);

        System.out.println("Lista: " + lista);
        System.out.println("Front: " + lista.front());
        System.out.println("Back: " + lista.back());

        System.out.println("popFront(): " + lista.popFront());

        System.out.println("Lista: " + lista);
        System.out.println("¿Vacía?: " + lista.isEmpty());

        lista.pushBack(10);

        System.out.println("popBack(): " + lista.popBack());

        System.out.println("Lista: " + lista);
        System.out.println("¿Vacía?: " + lista.isEmpty());

        // addBefore
        System.out.println("\nCaso 3: addBefore al primero");

        lista.pushBack(10);
        lista.pushBack(20);
        lista.pushBack(30);

        lista.addBefore(10, 5);

        System.out.println("Resultado: " + lista);
        System.out.println("Front: " + lista.front());
        System.out.println("Back: " + lista.back());

        // addAfter
        System.out.println("\nCaso 4: addAfter al último");

        lista.addAfter(30, 40);

        System.out.println("Resultado: " + lista);
        System.out.println("Front: " + lista.front());
        System.out.println("Back: " + lista.back());

        // erase
        System.out.println("\nCaso 5: erase");

        lista.erase(5);
        System.out.println("Después de borrar primero: " + lista);

        lista.erase(20);
        System.out.println("Después de borrar medio: " + lista);

        lista.erase(40);
        System.out.println("Después de borrar último: " + lista);

        System.out.println("Front: " + lista.front());
        System.out.println("Back: " + lista.back());

        lista.clear();

        System.out.println("\nDespués de clear:");
        System.out.println("Lista: " + lista);
        System.out.println("¿Vacía?: " + lista.isEmpty());
        System.out.println("Front: " + lista.front());
        System.out.println("Back: " + lista.back());
        System.out.println("Tamaño: " + lista.size());
    }
}