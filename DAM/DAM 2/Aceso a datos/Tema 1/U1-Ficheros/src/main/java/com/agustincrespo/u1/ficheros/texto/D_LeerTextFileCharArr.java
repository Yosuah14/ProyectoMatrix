package com.agustincrespo.u1.ficheros.texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Leemos un archivo de texto usando un buffer (array de char) creado
 * específicamente para leer más de un caracter a la vez.
 *
 * @author Agustín Crespo Valencia
 */
public class D_LeerTextFileCharArr {

    public static void main(String[] args) {
        try {
            File f = new File(".\\mis_archivos\\archivo1.txt");//declara fichero
            FileReader fr = new FileReader(f, StandardCharsets.UTF_8);

            int c_leidos = 0; // cantidad de caracteres leídos
            char[] buff = new char[64];

            while ((c_leidos= fr.read(buff))!= -1) {
                
                for (int i = 0; i < c_leidos; i++) {
                    System.out.print(buff[i]);
                }
            }
            fr.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero en la ruta indicada");
        } catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }
}
