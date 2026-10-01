package com.unal.medicion;

import com.unal.listas.ListaSimple;
import com.unal.listas.ListaSimpleConCola;
import com.unal.listas.ListaDoble;
import com.unal.listas.ListaDobleConCola;

import com.unal.pilas.PilaArregloDinamico;

import com.unal.colas.ColaArregloCircular;

import java.util.Random;

public class MainMedicion {

    // Tamaños de entrada que utilizaremos inicialmente.
   
    private static final int[] TAMANOS = {
        10,
        100,
        1_000,
        10_000,
        100_000,
        1_000_000,
        10_000_000
    };

   
    // Generador de números aleatorios.
   
    private static final Random RANDOM = new Random(12345);

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("      INICIO DE LAS MEDICIONES");
        System.out.println("====================================");

        medirListas();

        medirPila();

        medirCola();

        System.out.println("\n====================================");
        System.out.println("     MEDICIONES TERMINADAS");
        System.out.println("====================================");
    }

    // ======================================================
    //  LISTAS
    // ======================================================

    private static void medirListas() {

        String archivo = "resultados/resultados_listas.csv";

        Medidor.crearCSV(
                archivo,
                "estructura,tamano,pushFront,pushBack,popFront,popBack,find,erase,addBefore,addAfter"
        );

        System.out.println("\n===== LISTAS =====");

        for (int n : TAMANOS) {

            System.out.println("Tamaño: " + n);

            medirListaSimple(n, archivo);
            medirListaSimpleConCola(n, archivo);
            medirListaDoble(n, archivo);
            medirListaDobleConCola(n, archivo);
        }
    }

    // ---------------------------------------------------------
    // ListaSimple
    // ---------------------------------------------------------

    private static void medirListaSimple(
            int n,
            String archivo) {

        long tiempoPushFront;
        long tiempoPushBack;
        long tiempoPopFront;
        long tiempoPopBack;
        long tiempoFind;
        long tiempoErase;
        long tiempoAddBefore;
        long tiempoAddAfter;

        // pushFront
        {
            ListaSimple<Integer> listaPushFront =
                    crearListaSimple(n);

            int datoPushFront = numeroAleatorio();

            tiempoPushFront = Medidor.medir(
                    () -> listaPushFront.pushFront(datoPushFront)
            );
        }

        // pushBack
        {
            ListaSimple<Integer> listaPushBack =
                    crearListaSimple(n);

            int datoPushBack = numeroAleatorio();

            tiempoPushBack = Medidor.medir(
                    () -> listaPushBack.pushBack(datoPushBack)
            );
        }

        // popFront
        {
            ListaSimple<Integer> listaPopFront =
                    crearListaSimple(n);

            tiempoPopFront = Medidor.medir(
                    listaPopFront::popFront
            );
        }

        // popBack
        {
            ListaSimple<Integer> listaPopBack =
                    crearListaSimple(n);

            tiempoPopBack = Medidor.medir(
                    listaPopBack::popBack
            );
        }

        // find
        {
            ListaSimple<Integer> listaFind =
                    crearListaSimple(n);

            int objetivoFind = n - 1;

            tiempoFind = Medidor.medir(
                    () -> listaFind.find(objetivoFind)
            );
        }

        // erase
        {
            ListaSimple<Integer> listaErase =
                    crearListaSimple(n);

            int objetivoErase = n - 1;

            tiempoErase = Medidor.medir(
                    () -> listaErase.erase(objetivoErase)
            );
        }

        // addBefore
        {
            ListaSimple<Integer> listaAddBefore =
                    crearListaSimple(n);

            int objetivoAddBefore = n - 1;
            int nuevoDatoAddBefore = numeroAleatorio();

            tiempoAddBefore = Medidor.medir(
                    () -> listaAddBefore.addBefore(
                            objetivoAddBefore,
                            nuevoDatoAddBefore
                    )
            );
        }

        // addAfter
        {
            ListaSimple<Integer> listaAddAfter =
                    crearListaSimple(n);

            int objetivoAddAfter = n - 1;
            int nuevoDatoAddAfter = numeroAleatorio();

            tiempoAddAfter = Medidor.medir(
                    () -> listaAddAfter.addAfter(
                            objetivoAddAfter,
                            nuevoDatoAddAfter
                    )
            );
        }

        guardar(
                archivo,
                "ListaSimple",
                n,
                tiempoPushFront,
                tiempoPushBack,
                tiempoPopFront,
                tiempoPopBack,
                tiempoFind,
                tiempoErase,
                tiempoAddBefore,
                tiempoAddAfter
        );
    }

    // ---------------------------------------------------------
    // ListaSimpleConCola
    // ---------------------------------------------------------

    private static void medirListaSimpleConCola(
            int n,
            String archivo) {

        long tiempoPushFront;
        long tiempoPushBack;
        long tiempoPopFront;
        long tiempoPopBack;
        long tiempoFind;
        long tiempoErase;
        long tiempoAddBefore;
        long tiempoAddAfter;

        // pushFront
        {
            ListaSimpleConCola<Integer> listaPushFront =
                    crearListaSimpleConCola(n);

            int datoPushFront = numeroAleatorio();

            tiempoPushFront = Medidor.medir(
                    () -> listaPushFront.pushFront(datoPushFront)
            );
        }

        // pushBack
        {
            ListaSimpleConCola<Integer> listaPushBack =
                    crearListaSimpleConCola(n);

            int datoPushBack = numeroAleatorio();

            tiempoPushBack = Medidor.medir(
                    () -> listaPushBack.pushBack(datoPushBack)
            );
        }

        // popFront
        {
            ListaSimpleConCola<Integer> listaPopFront =
                    crearListaSimpleConCola(n);

            tiempoPopFront = Medidor.medir(
                    listaPopFront::popFront
            );
        }

        // popBack
        {
            ListaSimpleConCola<Integer> listaPopBack =
                    crearListaSimpleConCola(n);

            tiempoPopBack = Medidor.medir(
                    listaPopBack::popBack
            );
        }

        // find
        {
            ListaSimpleConCola<Integer> listaFind =
                    crearListaSimpleConCola(n);

            int objetivoFind = n - 1;

            tiempoFind = Medidor.medir(
                    () -> listaFind.find(objetivoFind)
            );
        }

        // erase
        {
            ListaSimpleConCola<Integer> listaErase =
                    crearListaSimpleConCola(n);

            int objetivoErase = n - 1;

            tiempoErase = Medidor.medir(
                    () -> listaErase.erase(objetivoErase)
            );
        }

        // addBefore
        {
            ListaSimpleConCola<Integer> listaAddBefore =
                    crearListaSimpleConCola(n);

            int objetivoAddBefore = n - 1;
            int nuevoDatoAddBefore = numeroAleatorio();

            tiempoAddBefore = Medidor.medir(
                    () -> listaAddBefore.addBefore(
                            objetivoAddBefore,
                            nuevoDatoAddBefore
                    )
            );
        }

        // addAfter
        {
            ListaSimpleConCola<Integer> listaAddAfter =
                    crearListaSimpleConCola(n);

            int objetivoAddAfter = n - 1;
            int nuevoDatoAddAfter = numeroAleatorio();

            tiempoAddAfter = Medidor.medir(
                    () -> listaAddAfter.addAfter(
                            objetivoAddAfter,
                            nuevoDatoAddAfter
                    )
            );
        }

        guardar(
                archivo,
                "ListaSimpleConCola",
                n,
                tiempoPushFront,
                tiempoPushBack,
                tiempoPopFront,
                tiempoPopBack,
                tiempoFind,
                tiempoErase,
                tiempoAddBefore,
                tiempoAddAfter
        );
    }

    // ---------------------------------------------------------
    //  ListaDoble
    // ---------------------------------------------------------

    private static void medirListaDoble(
            int n,
            String archivo) {

        long tiempoPushFront;
        long tiempoPushBack;
        long tiempoPopFront;
        long tiempoPopBack;
        long tiempoFind;
        long tiempoErase;
        long tiempoAddBefore;
        long tiempoAddAfter;

        // pushFront
        {
            ListaDoble<Integer> listaPushFront =
                    crearListaDoble(n);

            int datoPushFront = numeroAleatorio();

            tiempoPushFront = Medidor.medir(
                    () -> listaPushFront.pushFront(datoPushFront)
            );
        }

        // pushBack
        {
            ListaDoble<Integer> listaPushBack =
                    crearListaDoble(n);

            int datoPushBack = numeroAleatorio();

            tiempoPushBack = Medidor.medir(
                    () -> listaPushBack.pushBack(datoPushBack)
            );
        }

        // popFront
        {
            ListaDoble<Integer> listaPopFront =
                    crearListaDoble(n);

            tiempoPopFront = Medidor.medir(
                    listaPopFront::popFront
            );
        }

        // popBack
        {
            ListaDoble<Integer> listaPopBack =
                    crearListaDoble(n);

            tiempoPopBack = Medidor.medir(
                    listaPopBack::popBack
            );
        }

        // find
        {
            ListaDoble<Integer> listaFind =
                    crearListaDoble(n);

            int objetivoFind = n - 1;

            tiempoFind = Medidor.medir(
                    () -> listaFind.find(objetivoFind)
            );
        }

        // erase
        {
            ListaDoble<Integer> listaErase =
                    crearListaDoble(n);

            int objetivoErase = n - 1;

            tiempoErase = Medidor.medir(
                    () -> listaErase.erase(objetivoErase)
            );
        }

        // addBefore
        {
            ListaDoble<Integer> listaAddBefore =
                    crearListaDoble(n);

            int objetivoAddBefore = n - 1;
            int nuevoDatoAddBefore = numeroAleatorio();

            tiempoAddBefore = Medidor.medir(
                    () -> listaAddBefore.addBefore(
                            objetivoAddBefore,
                            nuevoDatoAddBefore
                    )
            );
        }

        // addAfter
        {
            ListaDoble<Integer> listaAddAfter =
                    crearListaDoble(n);

            int objetivoAddAfter = n - 1;
            int nuevoDatoAddAfter = numeroAleatorio();

            tiempoAddAfter = Medidor.medir(
                    () -> listaAddAfter.addAfter(
                            objetivoAddAfter,
                            nuevoDatoAddAfter
                    )
            );
        }

        guardar(
                archivo,
                "ListaDoble",
                n,
                tiempoPushFront,
                tiempoPushBack,
                tiempoPopFront,
                tiempoPopBack,
                tiempoFind,
                tiempoErase,
                tiempoAddBefore,
                tiempoAddAfter
        );
    }

    // ---------------------------------------------------------
    //  ListaDobleConCola
    // ---------------------------------------------------------

    private static void medirListaDobleConCola(
            int n,
            String archivo) {

        long tiempoPushFront;
        long tiempoPushBack;
        long tiempoPopFront;
        long tiempoPopBack;
        long tiempoFind;
        long tiempoErase;
        long tiempoAddBefore;
        long tiempoAddAfter;

        // pushFront
        {
            ListaDobleConCola<Integer> listaPushFront =
                    crearListaDobleConCola(n);

            int datoPushFront = numeroAleatorio();

            tiempoPushFront = Medidor.medir(
                    () -> listaPushFront.pushFront(datoPushFront)
            );
        }

        // pushBack
        {
            ListaDobleConCola<Integer> listaPushBack =
                    crearListaDobleConCola(n);

            int datoPushBack = numeroAleatorio();

            tiempoPushBack = Medidor.medir(
                    () -> listaPushBack.pushBack(datoPushBack)
            );
        }

        // popFront
        {
            ListaDobleConCola<Integer> listaPopFront =
                    crearListaDobleConCola(n);

            tiempoPopFront = Medidor.medir(
                    listaPopFront::popFront
            );
        }

        // popBack
        {
            ListaDobleConCola<Integer> listaPopBack =
                    crearListaDobleConCola(n);

            tiempoPopBack = Medidor.medir(
                    listaPopBack::popBack
            );
        }

        // find
        {
            ListaDobleConCola<Integer> listaFind =
                    crearListaDobleConCola(n);

            int objetivoFind = n - 1;

            tiempoFind = Medidor.medir(
                    () -> listaFind.find(objetivoFind)
            );
        }

        // erase
        {
            ListaDobleConCola<Integer> listaErase =
                    crearListaDobleConCola(n);

            int objetivoErase = n - 1;

            tiempoErase = Medidor.medir(
                    () -> listaErase.erase(objetivoErase)
            );
        }

        // addBefore
        {
            ListaDobleConCola<Integer> listaAddBefore =
                    crearListaDobleConCola(n);

            int objetivoAddBefore = n - 1;
            int nuevoDatoAddBefore = numeroAleatorio();

            tiempoAddBefore = Medidor.medir(
                    () -> listaAddBefore.addBefore(
                            objetivoAddBefore,
                            nuevoDatoAddBefore
                    )
            );
        }

        // addAfter
        {
            ListaDobleConCola<Integer> listaAddAfter =
                    crearListaDobleConCola(n);

            int objetivoAddAfter = n - 1;
            int nuevoDatoAddAfter = numeroAleatorio();

            tiempoAddAfter = Medidor.medir(
                    () -> listaAddAfter.addAfter(
                            objetivoAddAfter,
                            nuevoDatoAddAfter
                    )
            );
        }

        guardar(
                archivo,
                "ListaDobleConCola",
                n,
                tiempoPushFront,
                tiempoPushBack,
                tiempoPopFront,
                tiempoPopBack,
                tiempoFind,
                tiempoErase,
                tiempoAddBefore,
                tiempoAddAfter
        );
    }

    // ======================================================
    //  PILA
    // ======================================================

    private static void medirPila() {

        String archivo = "resultados/resultados_pila.csv";

        Medidor.crearCSV(
                archivo,
                "estructura,tamano,push,pop,peek,isEmpty,size,delete"
        );

        System.out.println("\n===== PILA =====");

        for (int n : TAMANOS) {

            System.out.println("Tamaño: " + n);

            long tiempoPush;
            long tiempoPop;
            long tiempoPeek;
            long tiempoIsEmpty;
            long tiempoSize;
            long tiempoDelete;

            // push
            {
                PilaArregloDinamico<Integer> pilaPush =
                        crearPila(n);

                int datoPush = numeroAleatorio();

                tiempoPush = Medidor.medir(
                        () -> pilaPush.push(datoPush)
                );
            }

            // pop
            {
                PilaArregloDinamico<Integer> pilaPop =
                        crearPila(n);

                tiempoPop = Medidor.medir(
                        pilaPop::pop
                );
            }

            // peek
            {
                PilaArregloDinamico<Integer> pilaPeek =
                        crearPila(n);

                tiempoPeek = Medidor.medir(
                        pilaPeek::peek
                );
            }

            // isEmpty
            {
                PilaArregloDinamico<Integer> pilaIsEmpty =
                        crearPila(n);

                tiempoIsEmpty = Medidor.medir(
                        pilaIsEmpty::isEmpty
                );
            }

            // size
            {
                PilaArregloDinamico<Integer> pilaSize =
                        crearPila(n);

                tiempoSize = Medidor.medir(
                        pilaSize::size
                );
            }

            // delete
            {
                PilaArregloDinamico<Integer> pilaDelete =
                        crearPila(n);

                int objetivoDelete = 0;

                tiempoDelete = Medidor.medir(
                        () -> pilaDelete.delete(objetivoDelete)
                );
            }

            guardar(
                    archivo,
                    "PilaArregloDinamico",
                    n,
                    tiempoPush,
                    tiempoPop,
                    tiempoPeek,
                    tiempoIsEmpty,
                    tiempoSize,
                    tiempoDelete
            );
        }
    }

    // ======================================================
    //  COLA
    // ======================================================

    private static void medirCola() {

        String archivo = "resultados/resultados_cola.csv";

        Medidor.crearCSV(
                archivo,
                "estructura,tamano,enqueue,dequeue,front,isEmpty,size,delete"
        );

        System.out.println("\n===== COLA =====");

        for (int n : TAMANOS) {

            System.out.println("Tamaño: " + n);

            long tiempoEnqueue;
            long tiempoDequeue;
            long tiempoFront;
            long tiempoIsEmpty;
            long tiempoSize;
            long tiempoDelete;

            // enqueue
            {
                ColaArregloCircular<Integer> colaEnqueue =
                        crearCola(n);

                int datoEnqueue = numeroAleatorio();

                tiempoEnqueue = Medidor.medir(
                        () -> colaEnqueue.enqueue(datoEnqueue)
                );
            }

            // dequeue
            {
                ColaArregloCircular<Integer> colaDequeue =
                        crearCola(n);

                tiempoDequeue = Medidor.medir(
                        colaDequeue::dequeue
                );
            }

            // front
            {
                ColaArregloCircular<Integer> colaFront =
                        crearCola(n);

                tiempoFront = Medidor.medir(
                        colaFront::front
                );
            }

            // isEmpty
            {
                ColaArregloCircular<Integer> colaIsEmpty =
                        crearCola(n);

                tiempoIsEmpty = Medidor.medir(
                        colaIsEmpty::isEmpty
                );
            }

            // size
            {
                ColaArregloCircular<Integer> colaSize =
                        crearCola(n);

                tiempoSize = Medidor.medir(
                        colaSize::size
                );
            }

            // delete
            {
                ColaArregloCircular<Integer> colaDelete =
                        crearCola(n);

                int objetivoDelete = n - 1;

                tiempoDelete = Medidor.medir(
                        () -> colaDelete.delete(objetivoDelete)
                );
            }

            guardar(
                    archivo,
                    "ColaArregloCircular",
                    n,
                    tiempoEnqueue,
                    tiempoDequeue,
                    tiempoFront,
                    tiempoIsEmpty,
                    tiempoSize,
                    tiempoDelete
            );
        }
    }

    // ==//==//==//==//==//==//==//==//==//==//==//==//
    //  MÉTODOS AUXILIARES PARA CREAR ESTRUCTURAS
    // ==//==//==//==//==//==//==//==//==//==//==//==//

    private static ListaSimple<Integer> crearListaSimple(int n) {

        ListaSimple<Integer> lista = new ListaSimple<>();

        for (int i = n - 1; i >= 0; i--) {
            lista.pushFront(i);
        }

        return lista;
    }

    private static ListaSimpleConCola<Integer>
            crearListaSimpleConCola(int n) {

        ListaSimpleConCola<Integer> lista =
                new ListaSimpleConCola<>();

        for (int i = n - 1; i >= 0; i--) {
            lista.pushFront(i);
        }

        return lista;
    }

    private static ListaDoble<Integer> crearListaDoble(int n) {

        ListaDoble<Integer> lista = new ListaDoble<>();

        for (int i = n - 1; i >= 0; i--) {
            lista.pushFront(i);
        }

        return lista;
    }

    private static ListaDobleConCola<Integer>
            crearListaDobleConCola(int n) {

        ListaDobleConCola<Integer> lista =
                new ListaDobleConCola<>();

        for (int i = n - 1; i >= 0; i--) {
            lista.pushFront(i);
        }

        return lista;
    }

    private static PilaArregloDinamico<Integer>
            crearPila(int n) {

        PilaArregloDinamico<Integer> pila =
                new PilaArregloDinamico<>();

        for (int i = 0; i < n; i++) {
            pila.push(i);
        }

        return pila;
    }

    private static ColaArregloCircular<Integer>
            crearCola(int n) {

        ColaArregloCircular<Integer> cola =
                new ColaArregloCircular<>();

        for (int i = 0; i < n; i++) {
            cola.enqueue(i);
        }

        return cola;
    }

   
    // Generar número aleatorio
    private static int numeroAleatorio() {
        return RANDOM.nextInt(1_000_000);
    }

    private static void guardar(
            String archivo,
            String estructura,
            int n,
            long... tiempos) {

        Medidor.guardarFila(
                archivo,
                estructura,
                n,
                tiempos
        );
    }
}