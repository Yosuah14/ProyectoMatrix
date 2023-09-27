package com.agustincrespo.ejemplologger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ejemplo básico de Log4j2 y su configuración
 *
 * @author agustincrespo
 */
public class EjemploLogger {

    public static void main(String[] args) {
        Logger logger = LogManager.getRootLogger();
        logger.trace("Prueba de una traza");
        logger.error("Prueba de un error, que tiene un nivel superior");
        logger.debug("Prueba debug");
        logger.info("Prueba de informacion");
        logger.warn("Prueba de warn");
        logger.fatal("Pureba de falta");
    }
}
