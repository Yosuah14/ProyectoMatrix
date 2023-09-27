package com.agustincrespo.ejemplologger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Clase2 {

    private int x;

    private static final Logger logger = LogManager.getLogger(Clase2.class);

    public Clase2() {
        this.x = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        logger.trace("Valor antiguo de X: " + this.x);
        this.x = x;
        logger.trace("Valor nuevo de X: " + this.x);
    }

}
