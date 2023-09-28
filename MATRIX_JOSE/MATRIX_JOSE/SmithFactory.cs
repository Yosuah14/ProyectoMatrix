using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class SmithFactory
    {
        private Smith generarPersonaje(string[,] matrix)
        {
            int coden = 1000;         
            string namep = PersonajeFactory.generarNombre();
            string namec = PersonajeFactory.generarCiudad();
            int age = RandomClass.numale(1, 75);
            int deathPer =0;
            int code = RandomClass.numale(100, coden);
            coden = code - 1;
            int length = RandomClass.numale(0, 14);
            int latitude = RandomClass.numale(0, 14);
            int capInf=RandomClass.numale(1, 5);
            Smith s = new Personaje(namep, namec, age, code, deathPer, length, latitude,capInf);
            return s;
        }
    }
}
