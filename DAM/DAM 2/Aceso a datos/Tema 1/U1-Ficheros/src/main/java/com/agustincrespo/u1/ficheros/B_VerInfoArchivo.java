package com.agustincrespo.u1.ficheros;

import java.io.File;

/**
 * Mostramos el contenido del archivo que se crea
 *
 * @author Agustín Crespo Valencia
 */
public class B_VerInfoArchivo {

    public static void main(String[] args) {
        System.out.println("INFORMACIÓN SOBRE EL FICHERO:");
        File f = new File(".\\mis_archivos\\whatsapp-phone.png");
        if (f.exists()) {
            System.out.println("Nombre del fichero  : " + f.getName());
            System.out.println("Ruta                : " + f.getPath());
            System.out.println("Ruta absoluta       : " + f.getAbsolutePath());
            System.out.println("Se puede leer       : " + f.canRead());
            System.out.println("Se puede escribir   : " + f.canWrite());
            System.out.println("Tamaño              : " + f.length());
            System.out.println("Es un directorio    : " + f.isDirectory());
            System.out.println("Es un fichero       : " + f.isFile());
            System.out.println("Nombre del directorio padre: " + f.getParent());
        }
    }
}
