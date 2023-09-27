package com.agustincrespo.u1.ficheros.texto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejemplo de escritura en un archivo de texto, carácter a carácter.
 *
 * @author Agustín Crespo Valencia
 */
public class B_EscribirTextFileChar {

    public static void main(String[] args) throws IOException {
        File f = new File("FicheroTexto1.txt");//declara fichero          
        FileWriter fw = new FileWriter(f); //crear el flujo de salida   

        String cadena = "Esta es la cadena de texto que se va a escribir en el archivo";
       //convierte un String en array de caracteres

        for (char c : cadena.toCharArray()) {
            fw.write(c);
        }
        fw.append('*');

        //nos aseguramos que se ha escrito todo
        fw.flush();

        fw.close();
    }
}
