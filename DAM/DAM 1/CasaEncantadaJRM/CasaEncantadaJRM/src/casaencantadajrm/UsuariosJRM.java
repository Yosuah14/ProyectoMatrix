
package casaencantadajrm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jose1
 */
public class UsuariosJRM implements Serializable {

    private String nombre;
    private String contrasenia;

    public UsuariosJRM() {
    }

    public UsuariosJRM(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "UsuariosJRM{"
                + "nombre='" + nombre + '\''
                + ", contrasenia='" + contrasenia + '\''
                + '}';
    }

    //genera un aleatoria(normamelte se pasa la longitud de una lista
    public static int generarAleatorio(int tamanio) {
        int ale = (int) (Math.random() * (tamanio + 0) - 0);
        return ale;
    }

    //Cambiamos la contraseña le pasamos la contraseña antigua la nueva la lista de usuairos y el nombre
    public void cambiarContrasenia(String nombre, String ca, String cn, ArrayList<Object> lista) {
        boolean encontrado = false;
        //Recorremos la lista
        for (Object obj : lista) {
            if (obj instanceof UsuariosJRM) {
                UsuariosJRM usuario = (UsuariosJRM) obj;
                //Si el nombre y la contraseña coincide con la antigua
                if (usuario.getNombre().equals(nombre) && usuario.getContrasenia().equals(ca)) {
                    //Cambiamos la contraseña por la nueva
                    usuario.setContrasenia(cn);
                    System.out.println("Contraseña cambiada exitosamente.");
                    encontrado = true;
                    break;
                }
            }
        }
        //Si no ponemos un mensale de que el usuairo no se encontro
        if (!encontrado) {
            System.out.println("No se encontró un usuario con el nombre y la contraseña proporcionados.");
        }
    }

    //Metodo para iniciar session y ver si coinciden la contraseña
    public boolean validarContrasenia(ArrayList<Object> lista, String nombreUsuario, String contrasenia) {
        boolean valida = false;

        // Iterar sobre cada elemento en la lista
        for (Object elemento : lista) {
            // Verificar si el elemento es una instancia de UsuariosJRM
            if (elemento instanceof UsuariosJRM) {
                // Convertir el elemento a UsuariosJRM
                UsuariosJRM usuario = (UsuariosJRM) elemento;

                // Comparar el nombre de usuario y la contraseña con los valores proporcionados
                if (usuario.getNombre().equals(nombreUsuario) && usuario.getContrasenia().equals(contrasenia)) {
                    // Se encontró una coincidencia válida
                    valida = true;

                }
            }
        }

        // Devolver el resultado de la validación
        return valida;
    }

    //Metodo que compruea que una casa pertenece a un usuario
    public static boolean comprobarCasa(ArrayList<Object> lista, String nUsuario) {
        boolean valido = false;
        for (Object casaEncantada : lista) {
            if (casaEncantada instanceof CasaEncantada && ((CasaEncantada) casaEncantada).getUsuario().equals(nUsuario)) {
                valido = true;
            }
        }
        return valido;
    }

    //Metodo que asigna a un objeto de tipo casa encantada una posicion aleatoria de una lista de casas encantadas con objetos del mismo usuario 
    public static Object elegirCasaAleatoria(ArrayList<Object> lista, String nUsuario, CasaEncantada casa) {
        //creamos un arraylist para guardar casas encantas del mismo usuario
        ArrayList<CasaEncantada> objetosV = new ArrayList<>();
        for (Object i : lista) {
            if (i instanceof CasaEncantada) {
                if (((CasaEncantada) i).getUsuario().equals(nUsuario)) {
                    //lo añadimos
                    objetosV.add((CasaEncantada) i);
                }
            }
        }
        //si no es nul ni menos y la lista tiene mas de una posicion
        if (objetosV != null || objetosV.size() > 0) {
            //genramos un numero aleatorio entre 0 y el tamaño de la lista
            int ale = UsuariosJRM.generarAleatorio((objetosV.size()));
            //el objeto de vuelta sera nulo si no hay nada en el arraylist y sino sera uno aleatorio de la lista de objetos del mismo usuario
            casa = objetosV.get(ale);
        }
        return casa;
    }
}
