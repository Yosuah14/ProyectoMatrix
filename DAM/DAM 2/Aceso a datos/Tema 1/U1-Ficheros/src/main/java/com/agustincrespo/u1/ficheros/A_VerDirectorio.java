package com.agustincrespo.u1.ficheros;

import java.io.File;

/**
 * Mostramos el contenido de un directorio concreto, en este caso, el actual.
 *
 * @author Agustín Crespo Valencia
 */
public class A_VerDirectorio {

    public static void main(String[] args) {
        String dir = ".";
        File f = new File(dir);
        String[] archivos = f.list();
        System.out.printf("Archivos del directorio actual: %d\n", archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            File f2 = new File(f, archivos[i]);
            System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivos[i], f2.isFile(),
                    f2.isDirectory());
        }
    }
}
