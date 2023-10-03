using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class NeoFactory
    {
        public Neo generarNeo(string[,] matrix)
        {           
            int coden = 1000;
            int deathPer;
            string namep = "NEOO";
            string namec = PersonajeFactory.generarCiudad();
            int age = RandomClass.numale(1, 75);
            deathPer = 0;
            string code = "C" + RandomClass.numale(100, coden).ToString();
            int length = RandomClass.numale(1, 14);
            int latitude = RandomClass.numale(1, 14);
            bool elegido = false;
            Neo n = new Neo(namep, namec, age, code, deathPer, length, latitude,elegido);
            return n;
        }


    }
}
