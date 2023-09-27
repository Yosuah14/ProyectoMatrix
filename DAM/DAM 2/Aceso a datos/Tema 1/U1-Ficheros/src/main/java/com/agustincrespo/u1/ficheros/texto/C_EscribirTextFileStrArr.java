package com.agustincrespo.u1.ficheros.texto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejemplo de escritura en un archivo de texto, en este caso mediante cadenas
 * completas.
 *
 * @author Agustín Crespo Valencia
 */
public class C_EscribirTextFileStrArr {

    public static void main(String[] args) throws IOException {
        File f = new File("FicheroTexto2.txt");//declara fichero          
        FileWriter fw = new FileWriter(f); //crear el flujo de salida   

        String provincias[] = {"Albacete", "Ciudad Real", "Cuenca",
            "Guadalajara", "Toledo"};

        for (int i = 0; i < provincias.length; i++) {
            fw.write(provincias[i]);
            fw.write("\n");
        }

        fw.flush();

        fw.close();
    }
}
