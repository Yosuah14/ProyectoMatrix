using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class Neo : Personaje
    {
        private bool elegido;
        public Neo(string namep, string namec, int age, int code, int deathPer, int length, int latitude, bool elegido) : base(namep, namec, age, code, deathPer = 0, length, latitude)
        {
            this.elegido = elegido;
        }
        public void esElegido()
        {
            Random random = new Random();
            int resultado = random.Next(0, 2); // Genera un número aleatorio entre 0 y 1 (0 inclusive, 2 excluido)

            this.elegido = (resultado == 1); // Cambia el valor de elegido a true si el resultado es 1, false si es 0
        }



    }
}
