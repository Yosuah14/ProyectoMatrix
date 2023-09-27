package casaencantadajrm;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author jose1 Clase que lee que busca por un parametro o que lee un fichero
 * mediante un array list o un objeto
 */
public class LectorJRM {

    File fichLector;

    //Constructores    
    public LectorJRM() {
    }

    public LectorJRM(File fichLector) {
        this.fichLector = fichLector;
    }

    // get & set
    public File getFichLector() {
        return fichLector;
    }

    public void setFichLector(File fichLector) {
        this.fichLector = fichLector;
    }

    /**
     * Método que recorre un fichero y lista todas las casas encantas
     * almacenadas en él fichero de Casas.txt
     *
     *
     * @return nº de casas encantadas leídas si se ha podido leer; -1 si no ha
     * podido leer
     */
    public int verContenidoJRM() {
        ObjectInputStream ois = null;

        int valorDevuelto = 0;
        CasaEncantada p;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichLector));
            p = (CasaEncantada) ois.readObject();

            while (p != null) {

                valorDevuelto++;
                System.out.println("\t***********Casa Encantada " + (valorDevuelto));
                System.out.println(p.toString());
                p = (CasaEncantada) ois.readObject();
            }

        } catch (EOFException eofe) {
            System.out.println("\t********************************************************************");
            System.out.println("\t*SE HAN LISTADO TODOS LOS DATOS DEL FICHERO. EN TOTAL: " + valorDevuelto + "  casas encantadas*");
            System.out.println("\t********************************************************************");
        } catch (IOException ioe) {
            //System.out.println("\t***********ERROR de E/S en la lectura " + ioe.getMessage());
            valorDevuelto = -1;
        } catch (ClassNotFoundException cnfe) {
            System.out.print("\t***********La clase no se ha encontrado " + cnfe.getMessage());
            valorDevuelto = -1;
        } catch (Exception e) {
            System.out.print("\t***********Se ha producido una EXCEPCIÓN en la lectura " + e.getMessage());
            valorDevuelto = -1;
        } finally {
           // System.out.println("El numero de casas encantadas de  es " + valorDevuelto);
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("\t***********No se puedo cerrar el stream en la lectura " + e.getMessage());
                }
            }
        }
        return valorDevuelto;
    }

    /**
     * Método que lee de un fichero todos los objetos de la clase Usuario o Casa
     * Encantada y busca el que coincida con el título que se pasa por
     * parámetro, cuando lo encuentra escribe su información en consola
     *
     * @param titulo de la Película a buscar
     * @return el objeto Película si se ha encontrado; null si no se ha
     * encontrado
     */
    public Object buscarJRM(String nombre) {
        Object p = null;
        boolean encontrado = false;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichLector));
            p = (UsuariosJRM) ois.readObject();
            while (p != null && !encontrado) {
                //Busca por nombre de usuario
                if (p instanceof UsuariosJRM usuariosJRM) {
                    if ((usuariosJRM.getNombre().equals(nombre))) {
                        encontrado = true;
                    } else {
                        p = (UsuariosJRM) ois.readObject();
                    }
                }

                if (p instanceof CasaEncantada) {

                    if (((CasaEncantada) p).getNombre().equals(nombre)) {
                        encontrado = true;
                    } else {
                        p = (CasaEncantada) ois.readObject();
                    }
                }
            }//Fin del while 
            if (!encontrado) {
                p = null;
            }
        } catch (EOFException eofe) {
            System.out.println("Este " + nombre + " no esta registrado");
            p = null;
        } catch (IOException ioe) {
            //System.out.println("ERROR de E/S: " + ioe.getMessage());
            p = null;
        } catch (Exception ex) {
            //System.out.println("ERROR al leer datos: " + ex.getMessage());
            p = null;
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error al cerrar el stream de lectura durante la búsqueda " + ioe.getMessage());
            }
        }//Fin del  try
        return p;
    }//Fin de busca

    /**
     * Método que lee de un fichero todos los objetos de la clase CasaEncantadas
     * y los almacena en una lista dinámica
     *
     * @return LinkedList con todos las Películas
     */
    public ArrayList<Object> leeJMR() {
        ArrayList<Object> lista = new ArrayList<>();
        Object p;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fichLector));
            //Mientras haya Películas en el fichero se ejecuta el while
            //Cuando salte la excepcion de EOF sale del bucle
            p = ois.readObject();
            while (p != null) {
                if (p instanceof UsuariosJRM) {
                    lista.add(p);
                    p = (UsuariosJRM) ois.readObject();
                } //ESTO SE TIENE QUE CONVERTIR EN UN ELSE
                else if (p instanceof CasaEncantada) {
                    lista.add(p);
                    p = (CasaEncantada) ois.readObject();
                }
            }//Fin del while 
        } catch (EOFException eofe) {
            //System.out.println("EOF. Se ha guardado todo el fichero en la lista");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("La clase no se ha encontrada: " + cnfe.getMessage());
        } catch (IOException ioe) {
            // System.out.println("ERROR de E/S: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una excepción al recorrer el fichero: " + e.getMessage());
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }//Fin try
        return lista;
    }//Fin de lee*/

}
