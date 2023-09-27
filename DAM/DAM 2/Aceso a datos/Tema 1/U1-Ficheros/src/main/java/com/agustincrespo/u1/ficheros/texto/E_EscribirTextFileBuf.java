package com.agustincrespo.u1.ficheros.texto;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Escribimos un fichero de texto, en vez de carácter a carácter, por líneas.
 *
 * @author Agustín Crespo Valencia
 */
public class E_EscribirTextFileBuf {

    public static void main(String[] args) {
        try {
            BufferedWriter fbw = new BufferedWriter(new FileWriter("FichTexto3.txt"));

            for (int i = 1; i < 11; i++) {
                fbw.write("Fila numero: " + i); //escribe una línea
                fbw.newLine(); //escribe un salto de línea
            }

            fbw.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero en la ruta indicada");
        } catch (IOException io) {
            System.out.println("Error de E/S");
        }
    }
}
