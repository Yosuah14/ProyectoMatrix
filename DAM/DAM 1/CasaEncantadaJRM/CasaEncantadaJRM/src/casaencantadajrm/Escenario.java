
package casaencantadajrm;

import java.io.Serializable;

/**
 *
 * @author Clase padre 
 */
public class Escenario implements Serializable {

    protected String nombre;
    protected TipoMonstruo tipoMonstruo;
    //Constructores

    public Escenario() {
    }

    public Escenario(String nombre, TipoMonstruo tipoMonstruo) {
        this.nombre = nombre;
        this.tipoMonstruo = tipoMonstruo;
    }
    //Getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoMonstruo(TipoMonstruo tipoMonstruo) {
        this.tipoMonstruo = tipoMonstruo;
    }

    public TipoMonstruo getTipoMonstruo() {
        return tipoMonstruo;
    }

   

    @Override
    public String toString() {
    return "Casa Encantada" +
            "\n nombre:" + nombre  +
            "\n tipoMonstruo:" + tipoMonstruo
            ;
}
}
