package com.agustincrespo.u1.ficheros;

import java.io.File;
import java.io.IOException;

/**
 * En este ejemplo se crean diferentes objetos, directorios y archivos. Para
 * ello, debes tener en cuenta qué es lo que deseas crear, ya que el método a
 * llamar es totalmente diferente.
 *
 * @author Agustín Crespo Valencia
 */
public class C_CrearFiles {

    public static void main(String[] args) {
        File d = new File(".\\mis_archivos\\NUEVODIR");
        File f1 = new File(d, "FICHERO1.TXT");
        File f2 = new File(d, "FICHERO2.TXT");

        d.mkdir(); // se crea el directorio, siempre que tengamos permisos

        try {
            if (f1.createNewFile()) {
                System.out.println("FICHERO1 creado correctamente...");
            } else {
                System.out.println("No se ha podido crear FICHERO1...");
            }

            if (f2.createNewFile()) {
                System.out.println("FICHERO2 creado correctamente...");
            } else {
                System.out.println("No se ha podido crear FICHERO2...");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        f1.renameTo(new File(d, "FICHERO1NUEVO"));//renombro FICHERO1

        try {
            File f3 = new File("./mis_archivos/NUEVODIR/FICHERO3.TXT");
            f3.createNewFile();//crea FICHERO3 en NUEVODIR
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
