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
 * @author Agustín Crespo Valencia
 */
public class G_EscribirTextFileBuffer {

    public static void main(String[] args) {
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter("FicheroTexto4.txt"));

            for (int i = 1; i < 20; i++) {
                bfw.write("Fila numero: " + i); //escribe una línea
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
