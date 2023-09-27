package com.agustincrespo.ejemplologger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Clase1 {

    private int v;

    private static final Logger logger = LogManager.getLogger(Clase1.class);

    public Clase1() {
        this.setV(0);
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        logger.trace("Valor antiguo de v: " + this.v);
        this.v = v;
        logger.trace("Valor nuevo de v: " + this.v);
    }

}
