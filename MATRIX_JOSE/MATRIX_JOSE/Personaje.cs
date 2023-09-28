using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class Personaje
    {
        
        public string namep { get; set; }
        private string namec { get; set; }
        private int age { get; set; }
        public int deathPer { get; set; }
        public string code { get; set; }

        public int length { get; set; }

        public int latitude { get; set; }
        public Personaje()
        {

        }

        public Personaje(string namep, string namec, int age, string code, int deathPer, int length, int latitude)
        {
            this.namep = namep;
            this.namec = namec;
            this.age = age;
            this.code = code;
            this.deathPer = deathPer;
            this.length = length;
            this.latitude = latitude;
        }
        public static bool SuperaPorcentajeMuerte(int deathPer)
        {
            return deathPer > 70;
        }


    }
}
