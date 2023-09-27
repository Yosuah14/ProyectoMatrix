package com.agustincrespo.u1.ficheros.texto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Leemos un fichero de texto, caracter a carácter. Ten en cuenta que ésto no es
 * que sea lo más eficiente.
 *
 * @author Agustín Crespo Valencia
 */
public class A_LeerTextFileChar {

    public static void main(String[] args) throws IOException {
        File f = new File(".\\mis_archivos\\archivo1.txt");
        FileReader fr = new FileReader(f); //crear el flujo de entrada  

        //También se puede hacer en una única línea
        //FileReader fr = new FileReader(".\\mis_archivos\\archivo1.txt");
        
        //se va leyendo carácter a carácter
        int i;
        while ((i = fr.read()) != -1) {
            //System.out.println((char) i + "==>" + i);
            System.out.print((char) i);
        }

        fr.close(); //cerrar fichero  
    }
}
