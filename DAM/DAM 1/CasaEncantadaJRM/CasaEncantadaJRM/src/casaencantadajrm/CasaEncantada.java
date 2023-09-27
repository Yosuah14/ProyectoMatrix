package casaencantadajrm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jose1
 */
public class CasaEncantada extends Escenario implements Serializable, Dibujablee {

    private int numeroPreguntas;
    private int tipoHabitacion;
    private String Usuario;

    public CasaEncantada(int numeroPreguntas, int tipoHabitacion, String Usuario, String nombre, TipoMonstruo tipoMonstruo) {
        super(nombre, tipoMonstruo);
        this.numeroPreguntas = numeroPreguntas;
        this.tipoHabitacion = tipoHabitacion;
        this.Usuario = Usuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public CasaEncantada(String nombre, TipoMonstruo tipoMonstruo) {
        super(nombre, tipoMonstruo);
    }

    public int getNumeroPreguntas() {
        return numeroPreguntas;
    }

    public void setNumeroPreguntas(int numeroPreguntas) {
        if (numeroPreguntas > 0 && numeroPreguntas <= 30) {
            this.numeroPreguntas = numeroPreguntas;
        } else {
            System.out.println("El número de preguntas debe ser mayor que 0 y menor o igual que 30.");
        }
    }

    public int getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(int tipoHabitacion) {
        if (tipoHabitacion >= 0 && tipoHabitacion <= 7) {
            this.tipoHabitacion = tipoHabitacion;
        } else {
            System.out.println("El tipo de habitación debe ser mayor o igual que 0 y menor o igual que 7.");
        }
    }

    public TipoMonstruo getTipoMonstruo() {
        return tipoMonstruo;
    }

    public void setTipoMonstruo(TipoMonstruo tipoMonstruo) {
        this.tipoMonstruo = tipoMonstruo;
    }

    @Override

    public String toString() {
        return super.toString() + ""
                + "\n"
                + "numeroPreguntas:" + numeroPreguntas + "\n"
                + "tipoHabitacion:" + tipoHabitacion + "\n"
                + " Usuario:" + Usuario + "\n";
    }
    //Distintas funciones del interface dibujar

    @Override
    public void dibujarDemonio() {
        System.out.println("   ,    ,    /\\   /\\\n"
                + "  /( /\\ )\\  _\\ \\_/ /_\n"
                + "  |\\_||_/| < \\_   _/ >\n"
                + "  \\______/  \\|0   0|/\n"
                + "    _\\/_   _(_  ^  _)_\n"
                + "   ( () ) /`\\|V\"\"\"V|/`\\\n"
                + "     {}   \\  \\_____/  /\n"
                + "     ()   /\\   )=(   /\\\n"
                + "  {}  /  \\_/\\=/\\_/  \\");
    }

    public void dibujarFantasma() {
        System.out.println("       ###, ,##, ,##,\r\n"
                + "       #  # #  # #  #\r\n"
                + "       ###  #  # #  #\r\n"
                + "       #  # #  # #  #\r\n"
                + "       ###' '##' '##'\r\n"
                + "            .--,\r\n"
                + "           /  (\r\n"
                + "          /    \\\r\n"
                + "         /      \\ \r\n"
                + "        /  0  0  \\\r\n"
                + "((()   |    ()    |   ()))\r\n"
                + "\\  ()  (  .____.  )  ()  /\r\n"
                + " |` \\_/ \\  `\"\"`  / \\_/ `|\r\n"
                + " |       `.'--'.`       |\r\n"
                + "  \\        `\"\"`        /\r\n"
                + "   \\                  /\r\n"
                + "    `.              .'    ,\r\n"
                + "jgs  |`             |  _.'|\r\n"
                + "     |              `-'  /\r\n"
                + "     \\                 .'\r\n"
                + "      `.____________.-'");

    }

    public void dibujarAngel() {
        System.out.println("    -=-\r\n"
                + "(\\  _  /)\r\n"
                + "( \\( )/ )\r\n"
                + "(       )\r\n"
                + " `>   <'\r\n"
                + " /     \\  \r\n"
                + " `-._.-'");
    }

    //Metodo que contiene preguntas y respuestas y que verifica que son validas
    public static void verificarRespuesta(CasaEncantada casa) throws IOException {
        String respuestaUsuario;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        //Array bidimensional que en las filas tiene las preguntas y en las columnas las respuestas de dichas preguntas
        String[][] preguntasRespuestas = {
            {"¿Cuál es la capital de Francia?", "París"},
            {"¿Cuál es el río más largo del mundo?", "Amazonas"},
            {"¿En qué año se descubrió América?", "1492"},
            {"¿Cuál es el país más poblado del mundo?", "China"},
            {"¿Quien ganó el mundial de fútbol en 2022?", "Argentina"}, // Agrega aquí más preguntas y respuestas
        };
        //Generamos la preugnta aleatoria
        int indicePreguntaAleatoria = UsuariosJRM.generarAleatorio(preguntasRespuestas.length);
        String preguntaAleatoria = preguntasRespuestas[indicePreguntaAleatoria][0];
        String respuestaEsperada = preguntasRespuestas[indicePreguntaAleatoria][1];
        System.out.println(preguntaAleatoria);
        respuestaUsuario = teclado.readLine();
        //le quitamos los espacios
        respuestaUsuario = respuestaUsuario.trim();
        if (respuestaUsuario.equalsIgnoreCase(respuestaEsperada)) {
            //si aciertas te aparece una angel
            System.out.println("Respuesta correcta!!!!");
            System.out.println("Saliste con vida jugador");
            casa.dibujarAngel();
        } else {
            //si fallas un demonio
            if (casa.tipoMonstruo == TipoMonstruo.DEMONIO) {
                System.out.println("Los demonios te atraparon");
                casa.dibujarDemonio();
            } else {
                System.out.println("Los fantasmas te atraparon");
                casa.dibujarFantasma();
            }
        }
        // Verificar si la respuesta del usuario coincide con la respuesta esperada, ignorando mayúsculas y minúsculas

    }

    //funcion que lee las casas encantadas de un usuario especifico
    public static void verCasaEncantada(ArrayList<Object> lista, String nUsu) {
        int cont = 0;
        for (Object object : lista) {
            if (object instanceof CasaEncantada && ((CasaEncantada) object).getUsuario().equals(nUsu)) {
                System.out.println(((CasaEncantada) object).toString());
                cont++;
            }

        }
        if (cont == 0) {
            System.out.println("No hay casas encantadas del usuario " + nUsu + " resgistradas");
        }

    }
}
