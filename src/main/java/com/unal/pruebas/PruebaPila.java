package com.unal.pruebas;

import com.unal.pilas.PilaArregloDinamico;

public class PruebaPila {

    public static void main(String[] args) {

        PilaArregloDinamico<Integer> pila =
                new PilaArregloDinamico<>();

        System.out.println("===== PRUEBA PILA =====");

        // Caso 1: pila vacía
        System.out.println("\n--- Pila vacía ---");

        System.out.println("isEmpty(): " + pila.isEmpty());
        System.out.println("size(): " + pila.size());
        System.out.println("peek(): " + pila.peek());
        System.out.println("pop(): " + pila.pop());
        System.out.println("delete(10): " + pila.delete(10));

        // Caso 2: push
        System.out.println("\n--- Push ---");

        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println("Pila: " + pila);
        System.out.println("size(): " + pila.size());
        System.out.println("peek(): " + pila.peek());

        // Caso 3: pop
        System.out.println("\n--- Pop ---");

        System.out.println("pop(): " + pila.pop());
        System.out.println("Pila: " + pila);

        System.out.println("pop(): " + pila.pop());
        System.out.println("Pila: " + pila);

        // Caso 4: delete
        System.out.println("\n--- Delete ---");

        pila.push(20);
        pila.push(40);
        pila.push(50);

        System.out.println("Pila antes: " + pila);

        System.out.println("delete(20): " + pila.delete(20));

        System.out.println("Pila después: " + pila);

        System.out.println("delete(100): " + pila.delete(100));

        // Caso 5: resize
        System.out.println("\n--- Resize ---");

        pila.clear();

        for (int i = 1; i <= 10; i++) {
            pila.push(i);
        }

        System.out.println("Pila después de insertar 10 elementos:");
        System.out.println(pila);

        System.out.println("size(): " + pila.size());
        System.out.println("peek(): " + pila.peek());

        // Caso 6: vaciar
        System.out.println("\n--- Vaciar pila ---");

        while (!pila.isEmpty()) {
            System.out.println("pop(): " + pila.pop());
        }

        System.out.println("Pila final: " + pila);
        System.out.println("isEmpty(): " + pila.isEmpty());
    }
}