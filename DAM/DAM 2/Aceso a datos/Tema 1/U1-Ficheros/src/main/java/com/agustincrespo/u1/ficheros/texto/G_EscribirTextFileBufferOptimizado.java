package com.agustincrespo.u1.ficheros.texto;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Escribimos un fichero de texto, en vez de carácter a carácter, por líneas
 * completas.<br>
 * Para hacerlo más sencillo, utilizamos la clase que mejor se adecua al
 * trabajo.
 *
 * Solución idéntica a la anterior, pero con el código bien escrito.
 *
 * @author Agustín Crespo Valencia
 */
public class G_EscribirTextFileBufferOptimizado {

    public static void main(String[] args) {
        String ruta = "FicheroTexto4.txt";
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(ruta));) {
            for (int i = 1; i < 20; i++) {
                bfw.write("Línea número: " + i); //escribe una línea
                bfw.newLine(); //escribe un salto de línea
            }
            bfw.flush();
            bfw.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero en la ruta indicada");
        } catch (IOException io) {
            System.out.println("Error de E/S");
        }
    }
}
