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
        public Neo()
        {
        }
        public Neo(string namep, string namec, int age, string code, int deathPer, int length, int latitude, bool elegido) : base(namep, namec, age, code, deathPer = 0, length, latitude)
        {
            this.elegido = elegido;
        }
        private bool esElegido()
        {
            Random random = new Random();
            int resultado = random.Next(0, 2); // Genera un número aleatorio entre 0 y 1 (0 inclusive, 2 excluido)

          return  (resultado == 1); // Cambia el valor de elegido a true si el resultado es 1, false si es 0
        }
        public Neo moverNeo(Neo neo) {
            neo.elegido = neo.esElegido();   
            if (neo.esElegido())
            {
                neo.latitude= RandomClass.numale(1, 14);
                neo.length = RandomClass.numale(1, 14);
                Console.WriteLine("NEO ES ELEGIDO");
            }
            else
            {
                Console.WriteLine("NEO NO ES ELEGIDO");
            }
            return neo;
        }




    }
}
