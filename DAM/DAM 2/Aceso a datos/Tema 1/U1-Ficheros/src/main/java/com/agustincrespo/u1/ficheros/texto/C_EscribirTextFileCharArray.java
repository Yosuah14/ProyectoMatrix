package com.agustincrespo.u1.ficheros.texto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejemplo de escritura en un archivo de texto, carácter a carácter.
 *
 * @author Agustín Crespo Valencia
 */
public class C_EscribirTextFileCharArray {

    public static void main(String[] args) throws IOException {
        File f = new File("FichTexto2.txt");//declara fichero          
        FileWriter fw = new FileWriter(f); //crear el flujo de salida   

        String clm[] = {"Albacete", "Ciudad Real", "Cuenca", "Guadalajara", "Toledo"};

        
        for (String p : clm) {
            fw.write(p+"\n");
        }
        fw.flush();

        fw.close();
    }
}
