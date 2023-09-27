
package casaencantadajrm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Clase que escribe distintos objetos en un fichero
 */
public class EscritorJRM {
    
    File fichEscritor;

    //Constructores
    public EscritorJRM() {
    }

    public EscritorJRM(File fichEscritor) {
        this.fichEscritor = fichEscritor;
    }

    //Getters&Setters
    public File getFichEscritor() {
        return fichEscritor;
    }

    public void setFichEscritor(File fichEscritor) {
        this.fichEscritor = fichEscritor;
    }

    /**
     * Método que escribe un objeto en un fichero
     *
     * @param p objeto a escribir en el fichero
     * @return 1 si se ha podido escribir; -1 si no ha podido escribir
     */
    public int escribirJRM(Object p) {
        ObjectOutputStream oos = null;
        int valorDevuelto;
        try {
            if (fichEscritor.exists()) {
                oos = new ObjectOutputStreamJRM(new FileOutputStream(fichEscritor, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(fichEscritor, true));
            }
            oos.writeObject(p);
            valorDevuelto = 1;
            oos.flush();
        } catch (IOException ioe) {
            //System.out.print("ERROR de E/S en la escritura " + ioe.getMessage());
            valorDevuelto = -1;
        } catch (Exception e) {
            System.out.print("Se ha producido una EXCEPCIÓN en la escritura " + e.getMessage());
            valorDevuelto = -1;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("No se puedo cerrar el stream en la escritura" + e.getMessage());
                }
            }
        }
        return valorDevuelto;
    }

    /**
     * Escribe en el fichero un conjunto de objetos almacenados en un array
     *
     * @param lista array dinámico de Objetos a guardar en el fichero
     * @return el número de objetos escritos si todo ha ido bien; -1 en caso de
     * error
     */
    public int escribirJRM(ArrayList<Object> lista) {
        ListIterator<Object> iteradorPel = lista.listIterator();
        Object p;
        int valorDevuelto = 0;

        // Se recorre el ArrayList
        while (iteradorPel.hasNext()) {
            p = iteradorPel.next();
            valorDevuelto = escribirJRM(p);
        }
        if (valorDevuelto == 1) {
            return lista.size();
        } else {
            return -1;
        }
    }
    
}
