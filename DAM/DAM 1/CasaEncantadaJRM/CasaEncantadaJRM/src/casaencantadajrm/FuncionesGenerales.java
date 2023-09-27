
package casaencantadajrm;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 *
 * @author Funciones que uso en el programa
 */
public class FuncionesGenerales {
    //Funcion que valida una contraseña con un patron
    public boolean validarContraseña(String contrasenia) {

        boolean validar = false;
        String patron = "^[A-Za-z]{6}[0-9]$";
        if (Pattern.matches(patron, contrasenia)) {
            validar = true;
        }
        return validar;
    }
    //Funcion limpiar pantalla
    public void limpiarPantalla() throws AWTException, InterruptedException, IOException {// buffer para leer datos desde el teclado
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_L);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_L);
    Thread.sleep(1000);

    }
}

