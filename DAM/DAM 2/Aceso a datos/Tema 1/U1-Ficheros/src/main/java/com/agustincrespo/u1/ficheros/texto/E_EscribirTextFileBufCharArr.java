package com.agustincrespo.u1.ficheros.texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * En este ejemplo se escribe en un archivo, usando un buffer para recuperar
 * datos de un fichero y escribirlos en otro fichero.
 *
 * El buffer se utiliza principalmente para ir mucho más rápido, no carácter a
 * carácter.
 *
 * @author Agustín Crespo Valencia
 */
public class E_EscribirTextFileBufCharArr {

    private static final int BUFFER_SIZE = 64;

    public static void main(String[] args) {
        String rutaOrigen = ".\\mis_archivos\\archivo1.txt";
        String rutaDestino = "Fichero3.txt";

        try {
            //fichero de origen
            File fo = new File(rutaOrigen);
            FileReader fr = new FileReader(fo);

            //fichero de destino
            File fd = new File(rutaDestino);
            FileWriter fw = new FileWriter(fd);

            int c_leidos; // cantidad de caracteres leídos
            char[] buffer = new char[BUFFER_SIZE];

            
            while ((c_leidos=fr.read(buffer))!=-1) {
                 fw.write(buffer, 0, c_leidos);
                
            }
            
            fr.close();
            fw.flush();
            fw.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero en la ruta indicada");
        } catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }
}
