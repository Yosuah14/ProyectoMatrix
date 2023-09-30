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

        public Smith()
        {
        }

        public Smith(string namep, string namec, int age, string code, int deathPer, int length, int latitude, int capinf) : base(namep, namec, age, code, deathPer = 0, length, latitude)
        {
            this.capInf = capinf;
        }
        public int infectar()
        {
            int inf = RandomClass.numale(1, 5);
            return inf = this.capInf;
        }

        public Smith movimientoSmith(Neo n,Smith s)
        {//comprobamos de primeras que ni neo ni smith son adyacentes
            if ((s.latitude==n.latitude+1 && s.length==n.length+1)||(s.latitude == n.latitude - 1 && s.length == n.length-1) ||(s.latitude == n.latitude - 1 && s.length == n.length + 1) ||(s.latitude == n.latitude + 1 && s.length == n.length - 1)) {
                Console.WriteLine("NEO Y SMITH SON ADYACENTES HAS QUE NEO NO SE MUEVA SMITH TAMPOCO");
                //vemos si estan en la misma fila o columna para que smith se mueva en zig zag
            }if (s.latitude == n.latitude|| s.length == n.length) {
                //vemos aqui si la (pos)columna es mayor mas abajo o (pos)la fila es mayor mas a la derecha
                if (s.latitude < n.latitude)
                {
                    s.latitude = s.latitude - 1;
                    s.length = n.length-1
                          ;    

                }
            }
        }

    }
}
