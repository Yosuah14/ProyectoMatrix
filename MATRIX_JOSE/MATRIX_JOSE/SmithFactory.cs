using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class SmithFactory
    {
        public Smith generarSmith(string[,] matrix)
        {
            Smith s = new Smith();
            int coden = 1000;
            int deathPer;
            string namep = "SMTH";
            string namec = PersonajeFactory.generarCiudad();
            int age = RandomClass.numale(1, 75);


            deathPer = 0;

            string code = "C" + RandomClass.numale(100, coden).ToString();

            int length = RandomClass.numale(0, 14);
            int latitude = RandomClass.numale(0, 14);
           
            int capinf = s.infectar();
            s = new Smith(namep, namec, age, code, deathPer, length, latitude, capinf);
            return s;
        }
    }
}
