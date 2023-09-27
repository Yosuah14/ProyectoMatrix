package com.agustincrespo.u1.ficheros.texto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Leer un fichero de texto algo más rápido, en vez de carácter a carácter,
 * línea a línea.<br>
 * Para poder hacer esto bien y de una forma más sencilla, usamos la clase
 * BufferedReader.
 *
 * @author Agustín Crespo Valencia
 */
public class F_LeerTextFileBuffer {

    public static void main(String[] args) {
        try {
            File f = new File(".\\mis_archivos\\archivo1.txt");//declara fichero
            BufferedReader fbr = new BufferedReader(new FileReader(f,StandardCharsets.UTF_8));

            String linea;
            while ((linea = fbr.readLine()) != null) {
                System.out.println(linea);
            }

            fbr.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero en la ruta indicada");
        } catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }
}
