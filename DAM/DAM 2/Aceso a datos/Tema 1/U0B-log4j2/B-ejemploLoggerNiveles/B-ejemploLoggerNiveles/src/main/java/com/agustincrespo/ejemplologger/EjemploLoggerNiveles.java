package com.agustincrespo.ejemplologger;

import com.agustincrespo.ejemplologger.subpkg.Clase3;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ejemplo de Log4j2 para configurar los logger propios por clase, no usar
 * únicamente la configuración general para Root
 *
 * @author agustincrespo
 */
public class EjemploLoggerNiveles {

    public static void main(String[] args) {
        Logger logger = LogManager.getRootLogger();
        logger.trace("Entrada a la clase principal");

        Clase1 c1 = new Clase1();
        c1.setV(Integer.MAX_VALUE);

        Clase2 c2 = new Clase2();
        c2.setX(Integer.MIN_VALUE);

        c1.setV(123456789);

        Clase3 c3 = new Clase3();
        c3.forzarDivisionCero();

        logger.trace("Finalización del programa");
    }
}
