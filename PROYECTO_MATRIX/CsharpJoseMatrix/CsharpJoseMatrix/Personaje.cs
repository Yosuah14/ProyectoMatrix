using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpJoseMatrix
{
   public class Personaje
    {
        private string namep { get; set; }
        private string namec { get; set; }
        private int age { get; set; }
        public int deathPer { get; set; }
        public int code { get; set; }

        public int length { get; set; }

        public       int latitude { get; set; }

        public Personaje(string namep, string namec, int age,int code, int deathPer, int length, int latitude)
        {
            this.namep = namep;
            this.namec = namec;
            this.age = age;
            this.code = code;
            this.deathPer = deathPer;
            this.length = length;
            this.latitude = latitude;
        }
        

    }
  
}
