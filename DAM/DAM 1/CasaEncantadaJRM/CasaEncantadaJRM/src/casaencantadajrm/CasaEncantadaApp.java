package casaencantadajrm;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jose1 aplicacion de Casa encantada que mediante un logueo de usuarios
 * puedes hacer varias cosas con objetos crearlos listar o responder preguntas
 */
public class CasaEncantadaApp {

    public static void main(String[] args) throws InterruptedException, IOException, AWTException {
        //Declaracion de variables
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int opcIni = 0;
        int opcJ2 = 0;
        boolean salida5 = false;
        String nCasa;
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
        ArrayList<Object> casasEncantadas = new ArrayList<>();
        ArrayList<Object> usuarios = new ArrayList<>();
        String ficheroUsu;
        String ficheroCasa;
        File usuariosf;
        File CasaEncantaf;
        UsuariosJRM usuario;
        ficheroUsu = "Usuarios.txt";
        ficheroCasa = "Casas.txt";
        usuariosf = new File(ficheroUsu);
        lectorU = new LectorJRM(usuariosf);
        escritorU = new EscritorJRM(usuariosf);
        CasaEncantaf = new File(ficheroCasa);
        lectorC = new LectorJRM(CasaEncantaf);
        escritorC = new EscritorJRM(CasaEncantaf);
        usuarios = lectorU.leeJMR();
        casasEncantadas = lectorC.leeJMR();
        //primer menu
        do {
            salida1 = false;
            System.out.println("\t **********MENU DE INICIO************");
            System.out.println("\t **********1.Iniciar Sesión**********");
            System.out.println("\t **********2.Registrarse*************");
            System.out.println("\t **********3.Salir*******************");
            System.out.println("\t Dime una opcion");
            //try catch que controla que metamos numeros enteros
            try {
                //inicializamos este objeto a null por queremos jugar mas de una vez
                casaEncantada = null;
                opcIni = Integer.parseInt(teclado.readLine());
                f.limpiarPantalla();

                switch (opcIni) {
                    case 1:
                        //iniciar sesion

                        System.out.println("Dime el nombre de Usuario");
                        nUsuario = teclado.readLine();
                        //miramos si el ususario exsite
                        usuario = (UsuariosJRM) lectorU.buscarJRM(nUsuario);
                        System.out.println("Buscando en la base de datos...");
                        Thread.sleep(1700);
                        //Si es null nos pregunta que si queremos registrarnos
                        if (usuario == null) {
                            System.out.println("Usuario no encontrado!!!");
                            System.out.println("¿Deseas registrarte? S para sí y N para no");
                            respuesta = teclado.readLine();
                            if (respuesta.equalsIgnoreCase("S")) {
                                salida1 = false;
                                f.limpiarPantalla();

                            }
                            if (respuesta.equalsIgnoreCase("N")) {
                                salida1 = true;
                                f.limpiarPantalla();
                            }
                        } else {
                            //ponemos el contador a 3 por si queremos loguearnos otra vez
                            contc = 3;
                            do {
                                //decrementamos si la contrasenia no coincide
                                System.out.println("Tienes " + contc + " intentos");
                                System.out.print("Escribe la contraseña: ");
                                contrasenia = teclado.readLine();
                                if (!usuario.validarContrasenia(usuarios, nUsuario, contrasenia)) {
                                    System.out.println("Contraseña incorrecta");
                                }
                                contc--;
                            } while (!usuario.validarContrasenia(usuarios, nUsuario, contrasenia) && (contc != 0));
                            //si acabas los intentos se borrara el usuario
                            if (contc == 0) {
                                System.out.println("Número de intentos agotados");
                                System.out.println("Borraremos el usuario y sus objetos asociados(si tiene) por motivos de seguridad");
                                if (usuarios != null) {
                                    //si el usuario no existe recorremos la lista con un iterator
                                    Iterator<Object> iterator = usuarios.iterator();
                                    while (iterator.hasNext()) {
                                        Object objeto = iterator.next();
                                        //borramos del arraylist el usuario con ese nombre
                                        if (objeto instanceof UsuariosJRM && ((UsuariosJRM) objeto).getNombre().equals(nUsuario)) {
                                            iterator.remove();
                                        }
                                    }
                                }
                                //borramos el fichero
                                usuariosf.delete();
                                //lo creamos
                                usuariosf = new File(ficheroUsu);

                                //Añadimos con el escritor de usuario cada elemento de la lista en el fichero
                                for (Object usuario1 : usuarios) {
                                    escritorU.escribirJRM(usuario1);
                                }
                                //hacemos lo mismo con la casas encantadas
                                if (casasEncantadas != null) {
                                    Iterator<Object> iterator = casasEncantadas.iterator();
                                    while (iterator.hasNext()) {
                                        Object objeto = iterator.next();
                                        if (objeto instanceof CasaEncantada && ((CasaEncantada) objeto).getUsuario().equals(nUsuario)) {
                                            iterator.remove();
                                        }
                                    }
                                }

                                CasaEncantaf.delete();
                                CasaEncantaf = new File(ficheroCasa);
                                for (Object casa1 : casasEncantadas) {
                                    escritorC.escribirJRM(casa1);
                                }
                                System.out.println("Usuario borrado");
                                System.out.println("Redirigiendo al menú...");
                                Thread.sleep(3000);
                                f.limpiarPantalla();
                            } else {
                                System.out.println("Contraseña válida");
                                System.out.println("Entrando al menú principal, por favor espere...");
                                Thread.sleep(1000);
                                f.limpiarPantalla();
                                do {
                                    //segundo menu 
                                    System.out.println("******MENU ENCANTADA**********");
                                    System.out.println("******1.Borrar Usuario********");
                                    System.out.println("******2.Cambiar contraseña****");
                                    System.out.println("******3.Jugar*****************");
                                    System.out.println("******4.Cerrar Sesion*********");
                                    System.out.print("Dime una opción: ");
                                    try {
                                        opcJ = Integer.parseInt(teclado.readLine());
                                        f.limpiarPantalla();
                                        switch (opcJ) {
                                           
                                            case 1:
                                                //preguntamos que si quiere borrar la contraseña
                                                System.out.println("¿Estás seguro de que quieres borrar tu usuario " + nUsuario + "?");
                                                System.out.println("Pulsa S para sí y N para no");
                                                respuesta = teclado.readLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    //Hacemos lo mismo que cuando se acaban el numero de intentos de la contraseña
                                                    if (usuarios != null) {
                                                        Iterator<Object> iterator = usuarios.iterator();
                                                        while (iterator.hasNext()) {
                                                            Object objeto = iterator.next();
                                                            if (objeto instanceof UsuariosJRM && ((UsuariosJRM) objeto).getNombre().equals(nUsuario)) {
                                                                iterator.remove();
                                                            }
                                                        }
                                                    }
                                                    usuariosf.delete();
                                                    usuariosf = new File(ficheroUsu);
                                                    //System.out.println("No se encontró ningún usuario con el nombre: " + nUsuario);

                                                    for (Object usuario1 : usuarios) {
                                                        escritorU.escribirJRM(usuario1);
                                                    }

                                                    if (casasEncantadas != null) {
                                                        Iterator<Object> iterator = casasEncantadas.iterator();
                                                        while (iterator.hasNext()) {
                                                            Object objeto = iterator.next();
                                                            if (objeto instanceof CasaEncantada && ((CasaEncantada) objeto).getUsuario().equals(nUsuario)) {
                                                                iterator.remove();
                                                            }
                                                        }
                                                    }
                                                    CasaEncantaf.delete();
                                                    CasaEncantaf = new File(ficheroCasa);
                                                    //System.out.println("No se encontró ningún usuario con el nombre: " + nUsuario);

                                                    for (Object casa1 : casasEncantadas) {
                                                        escritorC.escribirJRM(casa1);
                                                    }
                                                    System.out.println("Redirigiendo al menú...");
                                                    Thread.sleep(1000);
                                                    salida4 = true;
                                                    Thread.sleep(3000);
                                                    f.limpiarPantalla();

                                                } else if (respuesta.equalsIgnoreCase("N")) {
                                                    System.out.println("Redirigiendo al menu");
                                                    Thread.sleep(1000);
                                                    f.limpiarPantalla();
                                                }
                                                break;
                                            case 2:
                                                //Cambiar contraseña
                                                System.out.print("¿Estas seguro de que quieres cambiar la contraseña?(recuerda s para si y n para no)...");
                                                respuesta = teclado.readLine();
                                                if (respuesta.equalsIgnoreCase("S")) {
                                                    //Por motivos de seguridad pedimos la actual
                                                    System.out.println("Dime la contraseña que tienes actualmente");
                                                    contrasenia = teclado.readLine();
                                                    //si coincide pedira la otra
                                                    if (contrasenia.equals(usuario.getContrasenia())) {
                                                        System.out.println("Contraseña correcta");
                                                        //pedimos la nueva
                                                        System.out.println("Dime la nueva contraseña");
                                                        contrasenia = teclado.readLine();
                                                        //quitamos los espacios
                                                        contrasenia = contrasenia.trim();
                                                        //comprobamos que no sean iguales y que cumpla los estandares
                                                        if (contrasenia.equals(usuario.getContrasenia())) {
                                                            System.out.println("Las contraseñas no pueden ser iguales");
                                                            System.out.println("Volviendo al menú principal...");
                                                            Thread.sleep(1000);
                                                            
                                                            f.limpiarPantalla();

                                                        } else if (!f.validarContraseña(contrasenia)) {
                                                            System.out.println("Contraseña no válida");
                                                            System.out.println("Volviendo al menú principal...");
                                                            Thread.sleep(1000);
                                                            
                                                            f.limpiarPantalla();

                                                        } else {
                                                            //si es correcta nueva recorremos la lista donde se almacenan los usuarios y comprobamos que el nombre sea 
                                                            //igual al usuario que hemos introducido
                                                            for (int i = 0; i < usuarios.size(); i++) {
                                                                if (usuarios.get(i) instanceof UsuariosJRM && ((UsuariosJRM) usuarios.get(i)).getNombre().equals(nUsuario)) {
                                                                    ((UsuariosJRM) usuarios.get(i)).setContrasenia(contrasenia);
                                                                }
                                                            }
                                                            //borramos el fichero
                                                            usuariosf.delete();
                                                            usuariosf = new File(ficheroUsu);
                                                            //System.out.println("No se encontró ningún usuario con el nombre: " + nUsuario);
                                                            //escribimos el arraylist con el objeto modificado
                                                            for (Object usuario1 : usuarios) {
                                                                escritorU.escribirJRM(usuario1);
                                                            }

                                                            System.out.println("Cambiando contraseña...");
                                                            Thread.sleep(1000);

                                                            System.out.println("Volviendo al menú principal...");
                                                            Thread.sleep(1000);
                                                            salida4 = true;
                                                            f.limpiarPantalla();

                                                        }
                                                    } else {
                                                        System.out.println("La contraseña no es correcta!!!!!");
                                                        System.out.println("Volviendo al menu...");
                                                        Thread.sleep(1000);
                                                        
                                                        f.limpiarPantalla();
                                                    }

                                                } else if (respuesta.equalsIgnoreCase("n")) {
                                                    System.out.println("Volviendo al menu...");
                                                    
                                                    Thread.sleep(1000);

                                                    f.limpiarPantalla();
                                                }

                                                break;
                                            case 3:
                                                do {
                                                    System.out.println("*********1.Crear Objeto******************************************");
                                                    System.out.println("*********2.Listar Objetos****************************************");
                                                    System.out.println("*********3.Generar casa aleatoria (debes hacerlo para jugar)*****");
                                                    System.out.println("*********4.Entrar a la casa**************************************");
                                                    System.out.println("*********5.Salir al menú principal*******************************");
                                                    System.out.print("Dime una opción: ");
                                                    try {
                                                        opcJ2 = Integer.parseInt(teclado.readLine());
                                                        f.limpiarPantalla();
                                                        switch (opcJ2) {
                                                            case 1:
                                                                //Controlamos los posibles valores no validos para los parametro que sean enteros
                                                                    try {
                                                                //Pedimos todos los atributos
                                                                System.out.println("Dime el nombre de la casa:");
                                                                nCasa = teclado.readLine();
                                                                System.out.print("Ingrese el número de preguntas: ");
                                                                numeroPreguntas = Integer.parseInt(teclado.readLine());
                                                                System.out.print("Ingrese el tipo de habitación (0-7): ");
                                                                tipoHabitacion = Integer.parseInt(teclado.readLine());
                                                                System.out.print("Ingrese el tipo de monstruo (F para fantasma, D para demonio): ");
                                                                String tipoMonstruoInput = teclado.readLine().toUpperCase();
                                                                //Segun la respuesta ponemos que sea demonio o fantasma
                                                                if (tipoMonstruoInput.equals("F")) {
                                                                    tipoMonstruo = TipoMonstruo.FANTASMA;
                                                                } else if (tipoMonstruoInput.equals("D")) {
                                                                    tipoMonstruo = TipoMonstruo.DEMONIO;
                                                                } else {
                                                                    throw new IllegalArgumentException("Tipo de monstruo inválido.");
                                                                }
                                                                //Creamos la casa con las variables introducidas
                                                                casaEncantada = new CasaEncantada(numeroPreguntas, tipoHabitacion, nUsuario, nCasa, tipoMonstruo);
                                                                //lo añadimos al arraylist
                                                                casasEncantadas.add(casaEncantada);
                                                                //y LOS ESCRIBOS CON su escritor en el fichero Casas.txt
                                                                escritorC.escribirJRM(casaEncantada);
                                                                //Dejamos a null la casa para comprobar que se genera aleatroiamente                                                   
                                                                casaEncantada = null;
                                                                System.out.println("Objeto creado y guardado con éxito.");
                                                                salida5 = false;
                                                                f.limpiarPantalla();
                                                            } catch (NumberFormatException e) {
                                                                System.out.println("Error: debe ingresar un número válido.");
                                                            } catch (IOException e) {
                                                                System.out.println("Error al leer la entrada del usuario.");
                                                            } catch (IllegalArgumentException e) {
                                                                System.out.println("Error: " + e.getMessage());
                                                            }

                                                            break;
                                                            case 2:

                                                                CasaEncantada.verCasaEncantada(casasEncantadas, nUsuario);
                                                                Thread.sleep(5000);
                                                                f.limpiarPantalla();
                                                                
                                                                break;
                                                            case 3:
                                                                //Comprobamos que hayas generado aleatoriamente y que haya casas registradas 
                                                                if (casasEncantadas == null) {
                                                                    System.out.println("No hay ninguna casa registrada");
                                                                    Thread.sleep(1500);
                                                                    f.limpiarPantalla();
                                                                } else if (!UsuariosJRM.comprobarCasa(casasEncantadas, nUsuario)) {
                                                                    System.out.println("No hay casas del usuario " + nUsuario);
                                                                    Thread.sleep(1500);
                                                                    f.limpiarPantalla();

                                                                } else {
                                                                    //jugamos con la casa creada
                                                                    System.out.println("Gracias por jugar se con un objeto aleatorio objeto creado");
                                                                    System.out.println("Generando objeto...");
                                                                    Thread.sleep(1000);
                                                                    casaEncantada = (CasaEncantada) UsuariosJRM.elegirCasaAleatoria(casasEncantadas, nUsuario, casaEncantada);
                                                                    System.out.println("Objeto generado perfectamente");
                                                                    Thread.sleep(1500);
                                                                    f.limpiarPantalla();
                                                                }

                                                                break;
                                                            case 4:
                                                                //Comprobamos que hayas generado aleatoriamente y que haya casas registradas 
                                                                if (casasEncantadas == null) {
                                                                    System.out.println("No hay ninguna casa registrada");
                                                                    Thread.sleep(1000);
                                                                    f.limpiarPantalla();
                                                                } else if (casaEncantada == null) {
                                                                    System.out.println("Debes pulsar la opcion 3 para generar una casa ALEATORIA!!!!!");
                                                                    Thread.sleep(2000);
                                                                    f.limpiarPantalla();
                                                                } else {
                                                                    //mostramos la casa elegida
                                                                    System.out.println("La casa elegida aleatoriamente es:");
                                                                    System.out.println(casaEncantada.toString());
                                                                    System.out.println("Responde a la siguiente pregunta si no la aciertas los monstruos de la casa " + casaEncantada.getNombre() + " te matara...");
                                                                    CasaEncantada.verificarRespuesta(casaEncantada);
                                                                    System.out.println("Has acabado el juego...");
                                                                    Thread.sleep(3000);
                                                                    f.limpiarPantalla();
                                                                }

                                                                break;
                                                            case 5:
                                                                System.out.println("Volviendo al menu principal");
                                                                Thread.sleep(1000);
                                                                salida5 = true;
                                                                f.limpiarPantalla();
                                                                break;
                                                            default:
                                                                System.out.println("Parametros no validos");                                                
                                                                f.limpiarPantalla();

                                                        }

                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Error: Debes ingresar un número entero.");

                                                    } catch (IOException e) {
                                                        System.out.println("Error al leer la entrada del usuario.");
                                                    }
                                                } while (!salida5);
                                                break;
                                            case 4:
                                                salida4 = true;
                                                break;
                                            default:
                                                System.out.println("Parametros no validos");;

                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Error: Debes ingresar un número entero.");
                                    } catch (IOException e) {
                                        System.out.println("Error al leer la entrada del usuario.");
                                    }

                                } while (!salida4);

                            }
                        }

                        break;

                    case 2:
                        //Registrase
                        usuario = new UsuariosJRM();
                        do {
                            //Pedimos y comprobamos con el lector de usuarios que el nombre de usuario no exista
                            System.out.println("Dime el nombre de usuario que deseas introducir");
                            nUsuario = teclado.readLine();
                            usuario = (UsuariosJRM) lectorU.buscarJRM(nUsuario);
                            //Si es distinto existe el usuario
                            if (usuario != null) {
                                //Preguntamos que si se quiere registrar
                                System.out.println("El usuario ya está registrado");
                                System.out.println("¿Quieres registrarte de nuevo o volver al menú principal?");
                                System.out.println("Pulsa S para sí y N para no");
                                respuesta = teclado.readLine();
                                if (respuesta.equalsIgnoreCase("S")) {
                                    salida2 = false;
                                } else if (respuesta.equalsIgnoreCase("N")) {
                                    salida3 = true;
                                    salida2 = true;
                                    f.limpiarPantalla();
                                }

                            } else {
                                //Si es null es valido
                                System.out.println("USUARIO VÁLIDO");
                                System.out.println("Ahora introduce la contraseña (Seis letras y un digito al final ejemplo:abcDfg1)");
                                do {
                                    //pedimos una contraseña que pida el patron si no lo cumple se dira que si quiere poner otra
                                    System.out.println("Dime una contraseña");
                                    contrasenia = teclado.readLine();

                                    if (!f.validarContraseña(contrasenia)) {
                                        System.out.println("La contraseña no es válida");
                                        System.out.println("¿Quieres seguir intentándolo o volver al menú principal?");
                                        System.out.println("Pulsa S para sí y N para no");
                                        respuesta = teclado.readLine();
                                        if (respuesta.equalsIgnoreCase("S")) {
                                            salida3 = false;
                                        } else if (respuesta.equalsIgnoreCase("N")) {
                                            salida2 = true;
                                            salida3 = true;
                                        }
                                    } else {
                                        //si es valida
                                        System.out.println("CONTRASEÑA VÁLIDA");
                                        System.out.println("Registrando usuario...");
                                        Thread.sleep(1000);
                                        //creamos el usuario con las variables y lo añadimos tatno al arraylist como al fichero
                                        usuario = new UsuariosJRM(nUsuario, contrasenia);
                                        usuarios.add(usuario);
                                        escritorU.escribirJRM(usuario);
                                        System.out.println("Usuario registrado con ÉXITO!!!");
                                        System.out.println("Volviendo al menú principal...");
                                        Thread.sleep(1000);
                                        salida3 = true;
                                        salida2 = true;
                                        f.limpiarPantalla();
                                    }
                                } while (!salida3);
                            }
                        } while (!salida2);
                        break;

                    case 3:
                        //Salida de la aplicacion
                        System.out.println("Salieste del programa");
                        System.out.println("HASTA LA PROXIMA");
                        salida1 = true;
                        break;
                    default:
                        //Opcion 
                        System.out.println("Opción inválida");
                        f.limpiarPantalla();
                        break;

                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número entero.");
            } catch (IOException e) {
                System.out.println("Error al leer la entrada del usuario.");
            }
        } while (!salida1);

    }
}
