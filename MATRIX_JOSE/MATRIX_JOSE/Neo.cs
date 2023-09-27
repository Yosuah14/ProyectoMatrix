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
    }
}
