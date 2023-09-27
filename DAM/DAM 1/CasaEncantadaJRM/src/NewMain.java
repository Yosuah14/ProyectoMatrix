/*
package casaencantadajrm;

/**
 *
 * @author jose1
 */
/**
 * @param args the command line arguments
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class NewMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int opcIni = 0;
        int opcJ2 = 0;

        int numeroPreguntas;
        int tipoHabitacion;
        TipoMonstruo tipoMonstruo;
        FuncionesGenerales f = new FuncionesGenerales();
        String respuesta = "";
        int opcJ = 0;
        boolean salida1 = false;
        boolean salida2 = false;
        boolean salida3 = false;
        boolean salida4 = false;
        int contc = 3;
        String nUsuario = "";
        String contrasenia = "";
        LectorJRM lectorU;
        LectorJRM lectorC;
        EscritorJRM escritorU;
        EscritorJRM escritorC;
        CasaEncantada casaEncantada = null;
        int borrado = 0;
        ArrayList<Object> casasEncantadas = new ArrayList<>();
        ArrayList<Object> usuarios = new ArrayList<>();
        String ficheroUsu;
        String ficheroCasa;
        File usuariosf;
        File CasaEncantaf;

        UsuariosJRM usuario = null;

        ficheroUsu = "Usuarios.txt";
        ficheroCasa = "Casas.txt";

        usuariosf = new File(ficheroUsu);
        lectorU = new LectorJRM(usuariosf);
        escritorU = new EscritorJRM(usuariosf);
        CasaEncantaf = new File(ficheroCasa);
        lectorC = new LectorJRM(CasaEncantaf);
        escritorC = new EscritorJRM(CasaEncantaf);
        usuarios = lectorU.leeJMR();
        usuarios.toString();
        System.out.println("Entrando a la aplicación, espere un momento...");
        Thread.sleep(2000);
        do {
            salida1 = false;
            System.out.println("\t **********MENU DE INICIO************");
            System.out.println("\t **********1.Iniciar Sesión**********");
            System.out.println("\t **********2.Registrarse*************");
            System.out.println("\t **********3.Salir*******************");
            System.out.println("\t Dime una opcion");
            try {
                opcIni = Integer.parseInt(teclado.readLine());

                switch (opcIni) {
                    case 1:
                        usuarios.toString();
                        System.out.println("Dime el nombre de Usuario");
                        nUsuario = teclado.readLine();

                        usuario = (UsuariosJRM) lectorU.buscarJRM(nUsuario);
                        System.out.println("Buscando en la base de datos...");
                        Thread.sleep(1700);
                        if (usuario == null) {
                            System.out.println("Usuario no encontrado!!!");
                            System.out.println("¿Deseas registrarte? S para sí y N para no");
                            respuesta = teclado.readLine();
                            if (respuesta.equalsIgnoreCase("S")) {
                                salida1 = false;

                            } else if (respuesta.equalsIgnoreCase("N")) {
                                salida1 = true;
                            }
                        } else {
                            contc = 3;
                            do {
                                System.out.println("Tienes " + contc + " intentos");
                                System.out.print("Escribe la contraseña: ");

                                contrasenia = teclado.readLine();
                                if (!usuario.validarContrasenia(usuarios, nUsuario, contrasenia)) {
                                    System.out.println("Contraseña incorrecta");
                                }
                                contc--;
                            } while (!usuario.validarContrasenia(usuarios, nUsuario, contrasenia) && (contc != 0));
                            if (contc == 0) {
                                System.out.println("Número de intentos agotados");
                                System.out.println("Borraremos el usuario y sus objetos asociados(si tiene) por motivos de seguridad");
                                for (int i = 0; i < usuarios.size(); i++) {

                                    // Verificar si el objeto cumple con la condición
                                    if (usuario instanceof UsuariosJRM && ((UsuariosJRM) usuario).getNombre().equals(nUsuario)) {
                                        usuarios.remove(i); // Eliminar el objeto en la posición i
                                        break; // Salir del bucle una vez que se haya eliminado el objeto
                                    }
                                }
                                usuariosf.delete();
                                usuariosf = new File(ficheroUsu);
                                //System.out.println("No se encontró ningún usuario con el nombre: " + nUsuario);
                                System.out.println(usuarios.toString());
                                for (Object usuario1 : usuarios) {
                                    escritorU.escribirJRM(usuario1);
                                }

                                for (int i = 0; i < casasEncantadas.size(); i++) {

                                    // Verificar si el objeto cumple con la condición
                                    if (casaEncantada instanceof CasaEncantada && ((CasaEncantada) casaEncantada).getUsuario().equals(nUsuario)) {
                                        casasEncantadas.remove(i); // Eliminar el objeto en la posición i
                                        break; // Salir del bucle una vez que se haya eliminado el objeto
                                    }
                                }

                                CasaEncantaf.delete();
                                CasaEncantaf = new File(ficheroCasa);
                                //System.out.println("No se encontró ningún usuario con el nombre: " + nUsuario);
                                System.out.println(casasEncantadas.toString());
                                for (Object casa1 : casasEncantadas) {
                                    escritorC.escribirJRM(casa1);
                                }

                                System.out.println("Redirigiendo al menú...");
                                Thread.sleep(1000);
                                salida2 = true;
                            } else {
                                System.out.println("Contraseña válida");
                                System.out.println("Entrando al menú principal, por favor espere...");
                                Thread.sleep(1000);
                                do {
                                    System.out.println("******MENU ENCANTADA**********");
                                    System.out.println("******1.Borrar Usuario********");
                                    System.out.println("******2.Cambiar contraseña****");
                                    System.out.println("******3.Jugar*****************");
                                    System.out.println("******4.Salir*****************");
                                    System.out.print("Dime una opción: ");
                                    try {
                                        opcJ = Integer.parseInt(teclado.readLine());
                                        switch (opcJ) {
                                            case 1:
                                                System.out.println("¿Estás seguro de que quieres borrar tu usuario " + nUsuario + "?");
                                                System.out.println("Pulsa S para sí y N para no");
                                                respuesta = teclado.readLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    salida3 = false;
                                                    for (int i = 0; i < usuarios.size(); i++) {

                                                        // Verificar si el objeto cumple con la condición
                                                        if (usuario instanceof UsuariosJRM && ((UsuariosJRM) usuario).getNombre().equals(nUsuario)) {
                                                            usuarios.remove(i); // Eliminar el objeto en la posición i
                                                            break; // Salir del bucle una vez que se haya eliminado el objeto
                                                        }
                                                    }
                                                    usuariosf.delete();
                                                    usuariosf = new File(ficheroUsu);
                                                    //System.out.println("No se encontró ningún usuario con el nombre: " + nUsuario);
                                                    System.out.println(usuarios.toString());
                                                    for (Object usuario1 : usuarios) {
                                                        escritorU.escribirJRM(usuario1);
                                                    }

                                                    for (int i = 0; i < casasEncantadas.size(); i++) {

                                                        // Verificar si el objeto cumple con la condición
                                                        if (casaEncantada instanceof CasaEncantada && ((CasaEncantada) casaEncantada).getUsuario().equals(nUsuario)) {
                                                            casasEncantadas.remove(i); // Eliminar el objeto en la posición i
                                                            break; // Salir del bucle una vez que se haya eliminado el objeto
                                                        }
                                                    }

                                                    CasaEncantaf.delete();
                                                    CasaEncantaf = new File(ficheroCasa);
                                                    //System.out.println("No se encontró ningún usuario con el nombre: " + nUsuario);
                                                    System.out.println(casasEncantadas.toString());
                                                    for (Object casa1 : casasEncantadas) {
                                                        escritorU.escribirJRM(casa1);
                                                    }

                                                } else if (respuesta.equalsIgnoreCase("N")) {
                                                    salida3 = true;
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Dime la nueva contraseña");
                                                contrasenia = teclado.readLine();
                                                contrasenia = contrasenia.trim();
                                                if (contrasenia.equals(usuario.getContrasenia())) {
                                                    System.out.println("Las contraseñas no pueden ser iguales");
                                                    System.out.println("Volviendo al menú principal...");
                                                    Thread.sleep(1000);
                                                    salida3 = true;

                                                } else if (!f.validarContraseña(contrasenia)) {
                                                    System.out.println("Contraseña no válida");
                                                    System.out.println("Volviendo al menú principal...");
                                                    Thread.sleep(1000);
                                                    salida3 = true;

                                                } else {
                                                    if (respuesta.equalsIgnoreCase("S")) {
                                                        salida3 = false;
                                                        for (int i = 0; i < usuarios.size(); i++) {

                                                            // Verificar si el objeto cumple con la condición
                                                            if (usuario instanceof UsuariosJRM && ((UsuariosJRM) usuario).getNombre().equals(nUsuario)) {
                                                                usuarios.remove(i); // Eliminar el objeto en la posición i
                                                                usuario.setContrasenia(contrasenia);
                                                                usuarios.add(usuario);
                                                                break; // Salir del bucle una vez que se haya eliminado el objeto
                                                            }
                                                        }
                                                        usuariosf.delete();
                                                        usuariosf = new File(ficheroUsu);
                                                        //System.out.println("No se encontró ningún usuario con el nombre: " + nUsuario);

                                                        for (Object usuario1 : usuarios) {
                                                            escritorU.escribirJRM(usuario1);
                                                        }

                                                        System.out.println("Cambiando contraseña...");
                                                        Thread.sleep(1000);

                                                        System.out.println("Volviendo al menú principal...");
                                                        Thread.sleep(1000);
                                                        salida3 = true;

                                                    }
                                                    break;

                                                
                                        case 3:
                                                System.out.println("1.Crear Objeto");
                                                System.out.println("2.Listar Objetos");
                                                System.out.println("3.Salir al menú principal");
                                                System.out.print("Dime una opción: ");
                                                try {
                                                    opcJ2 = Integer.parseInt(teclado.readLine());
                                                    switch (opcJ2) {
                                                        case 1:
                                                            try {
                                                            System.out.print("Ingrese el número de preguntas: ");
                                                            numeroPreguntas = Integer.parseInt(teclado.readLine());

                                                            System.out.print("Ingrese el tipo de habitación (0-7): ");
                                                            tipoHabitacion = Integer.parseInt(teclado.readLine());

                                                            System.out.print("Ingrese el tipo de monstruo (F para fantasma, D para demonio): ");
                                                            String tipoMonstruoInput = teclado.readLine().toUpperCase();

                                                            if (tipoMonstruoInput.equals("F")) {
                                                                tipoMonstruo = TipoMonstruo.FANTASMA;
                                                            } else if (tipoMonstruoInput.equals("D")) {
                                                                tipoMonstruo = TipoMonstruo.DEMONIO;
                                                            } else {
                                                                throw new IllegalArgumentException("Tipo de monstruo inválido.");
                                                            }

                                                            casaEncantada = new CasaEncantada(numeroPreguntas, tipoHabitacion, nUsuario);
                                                            escritorC.escribirJRM(casaEncantada);
                                                            casasEncantadas.add(casaEncantada);

                                                            System.out.println("Objeto creado y guardado con éxito.");

                                                            // Imprimir información de la CasaEncantada
                                                            System.out.println(casaEncantada.toString());

                                                        } catch (NumberFormatException e) {
                                                            System.out.println("Error: debe ingresar un número válido.");
                                                        } catch (IOException e) {
                                                            System.out.println("Error al leer la entrada del usuario.");
                                                        } catch (IllegalArgumentException e) {
                                                            System.out.println("Error: " + e.getMessage());
                                                        }
                                                        break;
                                                        default:
                                                            System.out.println("Parámetros inválidos");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Error: Debes ingresar un número entero.");
                                                    opcIni = 0; // Reiniciar la opción para volver a mostrar el menú
                                                } catch (IOException e) {
                                                    System.out.println("Esto es un catch");
                                                }

                                                break;
                                            case 4:
                                                System.out.println("Volviendo al menú principal...");
                                                Thread.sleep(1000);
                                                salida3 = true;
                                                break;
                                            default:
                                                System.out.println("Parámetros inválidos");
                                                break;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Error: Debes ingresar un número entero.");
                                        opcIni = 0; // Reiniciar la opción para volver a mostrar el menú
                                    }catch (IOException e) {
                                        System.out.println("Esto es un catch");
                                    }

                                    }
                                    while (!salida3);
                                }
                            }

                            break;

                        
                case 2:
                        usuario = new UsuariosJRM();
                        do {
                            System.out.println("Dime el nombre de usuario que deseas introducir");
                            nUsuario = teclado.readLine();

                            usuario = (UsuariosJRM) lectorU.buscarJRM(nUsuario);
                            if (usuario != null) {
                                System.out.println("El usuario ya está registrado");
                                System.out.println("¿Quieres registrarte de nuevo o volver al menú principal?");
                                System.out.println("Pulsa S para sí y N para no");
                                respuesta = teclado.readLine();
                                if (respuesta.equalsIgnoreCase("S")) {
                                    salida4 = false;
                                } else if (respuesta.equalsIgnoreCase("N")) {
                                    salida4 = true;
                                }

                            } else {
                                System.out.println("USUARIO VÁLIDO");
                                System.out.println("Ahora introduce la contraseña (Al menos una letra mayúscula, uno o más números)");

                                do {
                                    System.out.println("Dime una contraseña");
                                    contrasenia = teclado.readLine();

                                    if (!f.validarContraseña(contrasenia)) {
                                        System.out.println("La contraseña no es válida");
                                        System.out.println("¿Quieres seguir intentándolo o volver al menú principal?");
                                        System.out.println("Pulsa S para sí y N para no");
                                        respuesta = teclado.readLine();
                                        if (respuesta.equalsIgnoreCase("S")) {
                                            salida4 = false;
                                        } else if (respuesta.equalsIgnoreCase("N")) {
                                            salida4 = true;
                                        }
                                    } else {
                                        System.out.println("CONTRASEÑA VÁLIDA");
                                        System.out.println("Registrando usuario...");
                                        Thread.sleep(1000);
                                        usuario = new UsuariosJRM(nUsuario, contrasenia);
                                        escritorU.escribirJRM(usuario);
                                        usuarios.add(usuario);
                                        System.out.println("Usuario registrado con ÉXITO!!!");
                                        System.out.println("Volviendo al menú principal...");
                                        Thread.sleep(1000);
                                        salida4 = true;
                                    }
                                } while (!salida4);
                            }

                        } while (!salida4);

                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        salida1 = true;
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número entero.");
            }catch (IOException e) {
                System.out.println("Error al leer la entrada del usuario.");
            }
            }

        } while (!salida1);
    }
}
*/
