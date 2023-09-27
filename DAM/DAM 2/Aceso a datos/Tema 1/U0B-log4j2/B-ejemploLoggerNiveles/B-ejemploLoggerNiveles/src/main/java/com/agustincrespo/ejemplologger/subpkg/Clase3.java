package com.agustincrespo.ejemplologger.subpkg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Clase3 {

    private static final Logger logger = LogManager.getLogger(Clase3.class);

    public Clase3() {
    }

    public void forzarDivisionCero() {
        try {
            this.logger.trace("Inicio de la división entre 0");
            int i = 99 / 0;
            System.out.println(i);
        } catch (Exception e) {
            this.logger.error(e.getMessage());
        } finally {
            this.logger.trace("Finalización de la división entre 0");
        }
    }

}
