package casaencantadajrm;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author jose1 Clase para sobrescribir la clase ObjectOutputStream para evitar
 * que se cree la cabecera que impida que la información añadida sea leída
 */
public class ObjectOutputStreamJRM extends ObjectOutputStream {

    //Sobrescribimos el método que crea la cabecera
    @Override
    protected void writeStreamHeader() throws IOException {
        //no se hace nada
    }

    //constructores
    public ObjectOutputStreamJRM() throws IOException {
        super();
    }

    public ObjectOutputStreamJRM(OutputStream out) throws IOException {
        super(out);
    }

}
