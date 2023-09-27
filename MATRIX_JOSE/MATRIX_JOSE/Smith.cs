using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class Smith : Personaje
    {
        private int capInf;

        public Smith(string namep, string namec, int age, int code, int deathPer, int length, int latitude, int capinf) : base(namep, namec, age, code, deathPer = 0, length, latitude)
        {
            this.capInf = capinf;
        }


    }
}
