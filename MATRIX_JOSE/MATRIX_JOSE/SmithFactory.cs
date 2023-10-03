using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class SmithFactory
    {
        /*
        *Genera a Neo y comprueba que no sea la misma posicon de smith
        */
        public Smith generarSmith(string[,] matrix, Neo neo)
        {
            int latitude = 0;
            int length = 0;
            Smith s = new Smith();
            int coden = 1000;
            int deathPer;
            string namep = "SMTH";
            string namec = PersonajeFactory.generarCiudad();
            int age = RandomClass.numale(1, 75);
            deathPer = 0;
            string code = "C" + RandomClass.numale(100, coden).ToString();
            do
            {
                length = RandomClass.numale(1, 14);
            } while (length == neo.length);
            do
            {
                latitude = RandomClass.numale(1, 14);
            } while (latitude == neo.latitude);

            int capinf = s.infectar();
            s = new Smith(namep, namec, age, code, deathPer, length, latitude, capinf);
            return s;
        }
    }
}
