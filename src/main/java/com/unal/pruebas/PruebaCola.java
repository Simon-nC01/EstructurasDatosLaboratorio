package com.unal.pruebas;

import com.unal.colas.ColaArregloCircular;

public class PruebaCola {

    public static void main(String[] args) {

        ColaArregloCircular<Integer> cola =
                new ColaArregloCircular<>();

        System.out.println("===== PRUEBA COLA =====");

        // Caso 1: cola vacía
        System.out.println("\n--- Cola vacía ---");

        System.out.println("isEmpty(): " + cola.isEmpty());
        System.out.println("size(): " + cola.size());
        System.out.println("front(): " + cola.front());
        System.out.println("dequeue(): " + cola.dequeue());
        System.out.println("delete(10): " + cola.delete(10));

        // Caso 2: enqueue
        System.out.println("\n--- Enqueue ---");

        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);

        System.out.println("Cola: " + cola);
        System.out.println("size(): " + cola.size());
        System.out.println("front(): " + cola.front());

        // Caso 3: dequeue
        System.out.println("\n--- Dequeue ---");

        System.out.println("dequeue(): " + cola.dequeue());
        System.out.println("Cola: " + cola);

        System.out.println("dequeue(): " + cola.dequeue());
        System.out.println("Cola: " + cola);

        // Caso 4: comportamiento circular
        System.out.println("\n--- Comportamiento circular ---");

        cola.enqueue(40);
        cola.enqueue(50);
        cola.enqueue(60);

        System.out.println("Cola: " + cola);

        System.out.println("dequeue(): " + cola.dequeue());
        System.out.println("Cola: " + cola);

        cola.enqueue(70);
        cola.enqueue(80);

        System.out.println("Después de volver a insertar:");
        System.out.println("Cola: " + cola);

        // Caso 5: delete
        System.out.println("\n--- Delete ---");

        System.out.println("delete(50): " + cola.delete(50));
        System.out.println("Cola: " + cola);

        System.out.println("delete(100): " + cola.delete(100));
        System.out.println("Cola: " + cola);

        // Caso 6: resize
        System.out.println("\n--- Resize ---");

        while (!cola.isEmpty()) {
            cola.dequeue();
        }

        for (int i = 1; i <= 10; i++) {
            cola.enqueue(i);
        }

        System.out.println("Cola después de insertar 10 elementos:");
        System.out.println(cola);

        System.out.println("size(): " + cola.size());
        System.out.println("front(): " + cola.front());

        // Caso 7: vaciar
        System.out.println("\n--- Vaciar cola ---");

        while (!cola.isEmpty()) {
            System.out.println("dequeue(): " + cola.dequeue());
        }

        System.out.println("Cola final: " + cola);
        System.out.println("isEmpty(): " + cola.isEmpty());
    }
}