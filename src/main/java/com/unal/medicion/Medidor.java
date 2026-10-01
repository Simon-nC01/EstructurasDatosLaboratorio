package com.unal.medicion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Medidor {

    // Mide una operación una sola vez.
    // @param operacion operación que se desea medir
    // @return tiempo de ejecución en nanosegundos
    
    public static long medir(Runnable operacion) {

        long inicio = System.nanoTime();

        operacion.run();

        long fin = System.nanoTime();

        return fin - inicio;
    }

    // Crea un archivo CSV y escribe su encabezado.
    // @param nombreArchivo nombre del archivo
    
    public static void crearCSV(
            String nombreArchivo,
            String encabezado) {

        File archivo = new File(nombreArchivo);
        File carpetaPadre = archivo.getParentFile();

        if (carpetaPadre != null && !carpetaPadre.exists()) {
            carpetaPadre.mkdirs();
        }

        try (PrintWriter escritor =
                     new PrintWriter(new FileWriter(archivo))) {

            escritor.println(encabezado);

        } catch (IOException e) {

            System.out.println(
                    "Error al crear el archivo: " + nombreArchivo
            );

            e.printStackTrace();
        }
    }

    // Agrega una medición al archivo CSV.
    // @param nombreArchivo archivo donde se escribe
    // @param estructura estructura utilizada
    // @param metodo método medido
    // @param tamano tamaño de entrada
    // @param tiempo tiempo medido en nanosegundos
     
    public static void guardarFila(
            String nombreArchivo,
            String estructura,
            int tamano,
            long... tiempos) {

        try (PrintWriter escritor =
                     new PrintWriter(
                             new FileWriter(nombreArchivo, true))) {

            StringBuilder fila = new StringBuilder();

            fila.append(estructura);
            fila.append(",");
            fila.append(tamano);

            for (long tiempo : tiempos) {
                fila.append(",");
                fila.append(tiempo);
            }

            escritor.println(fila);

        } catch (IOException e) {

            System.out.println(
                    "Error al escribir en el archivo: "
                    + nombreArchivo
            );

            e.printStackTrace();
        }
    }
}