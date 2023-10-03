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

        public Smith movimientoSmith(Neo n, Smith s, List<Personaje> elegidos, MatrixFactory matrixf, Matrix matrix)

        {//comprobamos de primeras que ni neo ni smith son adyacentes

            if ((s.latitude == n.latitude + 1 && s.length == n.length + 1) || (s.latitude == n.latitude - 1 && s.length == n.length - 1) || (s.latitude == n.latitude - 1 && s.length == n.length + 1) || (s.latitude == n.latitude + 1 && s.length == n.length - 1))
            {
                Console.WriteLine("NEO Y SMITH SON ADYACENTES HAS QUE NEO NO SE MUEVA SMITH TAMPOCO");
                //vemos si estan en la misma fila o columna para que smith se mueva en zig zag
                return s;
            }
            //Comprobamos que neo no es al lado de las casillas no adyacentes
            if ((s.latitude == n.latitude + 1 && s.length == n.length || (s.latitude == n.latitude - 1 && s.length == n.length) || (s.latitude == n.latitude && s.length == n.length + 1) || (s.latitude == n.latitude && s.length == n.length - 1)))
            {
                Console.WriteLine("SMITH ESTA AL LADO DE NEO EN UNA CASILLA NO ADYACENTE,HASTA QUE NEO NO SE MUEVA NO SEGUIRA EL JUEGO");
                return s;
            }

            if (s.latitude == n.latitude || s.length == n.length)
            {
                //vemos aqui si la (pos)columna es mayor mas abajo o (pos)la fila es mayor mas a la derecha
                //Si la fila de neo es mayor que la smith

                if (n.latitude > s.latitude)
                {
                    //Aqui se va a la diagonal mas cercana
                    s.latitude = s.latitude + 1;
                    s.length = s.length - 1;
                    //Si la posicon no es una adyacente a neo no se movera
                    matrix = matrixf.InicializarMatrizConPersonajes(elegidos, n, s);
                    matrixf.ImprimirMatriz(matrix.MatrixArray);

                    if (!(s.latitude == n.latitude + 1 && s.length == n.length + 1) || !(s.latitude == n.latitude - 1 && s.length == n.length - 1) || !(s.latitude == n.latitude - 1 && s.length == n.length + 1) || !(s.latitude == n.latitude + 1 && s.length == n.length - 1))
                    {
                        s.latitude = s.latitude + 1;
                        s.length = s.length + 1;
                    }
                    return s;
                }
                if (n.latitude < s.latitude)
                {
                    s.latitude = s.latitude - 1;
                    s.length = s.length - 1;
                    matrix = matrixf.InicializarMatrizConPersonajes(elegidos, n, s);
                    matrixf.ImprimirMatriz(matrix.MatrixArray);

                    if (!(s.latitude == n.latitude + 1 && s.length == n.length + 1) || !(s.latitude == n.latitude - 1 && s.length == n.length - 1) || !(s.latitude == n.latitude - 1 && s.length == n.length + 1) || !(s.latitude == n.latitude + 1 && s.length == n.length - 1))
                    {
                        s.latitude = s.latitude - 1;
                        s.length = s.length + 1;
                    }
                    return s;

                }
                if (n.length < s.length)
                {
                    s.latitude = s.latitude - 1;
                    s.length = s.length - 1;
                    matrix = matrixf.InicializarMatrizConPersonajes(elegidos, n, s);
                    matrixf.ImprimirMatriz(matrix.MatrixArray);
                    if (!(s.latitude == n.latitude + 1 && s.length == n.length + 1) || !(s.latitude == n.latitude - 1 && s.length == n.length - 1) || !(s.latitude == n.latitude - 1 && s.length == n.length + 1) || !(s.latitude == n.latitude + 1 && s.length == n.length - 1))
                    {
                        s.latitude = s.latitude + 1;
                        s.length = s.length - 1;
                    }
                    return s;

                }
                if (n.length > s.length)
                {
                    s.latitude = s.latitude - 1;
                    s.length = s.length + 1;
                    matrix = matrixf.InicializarMatrizConPersonajes(elegidos, n, s);
                    matrixf.ImprimirMatriz(matrix.MatrixArray);

                    if (!(s.latitude == n.latitude + 1 && s.length == n.length + 1) || !(s.latitude == n.latitude - 1 && s.length == n.length - 1) || !(s.latitude == n.latitude - 1 && s.length == n.length + 1) || !(s.latitude == n.latitude + 1 && s.length == n.length - 1))
                    {
                        s.latitude = s.latitude + 1;
                        s.length = s.length + 1;
                    }
                    return s;


                }
            }
            //Sino es adyacente ni esta en una fila o columna igual que neo se movera normal se movera normal en diagonal
            else
            {
                if ((n.latitude > s.latitude) && (n.length > s.length))
                {
                    s.latitude = s.latitude + 1;
                    s.length = s.length + 1;
                }
                if ((n.latitude < s.latitude) && (n.length < s.length))
                {
                    s.latitude = s.latitude - 1;
                    s.length = s.length - 1;
                }
                if ((n.latitude > s.latitude) && (n.length < s.length))
                {
                    s.latitude = s.latitude + 1;
                    s.length = s.length - 1;
                }
                if ((n.latitude < s.latitude) && (n.length > s.length))
                {
                    s.latitude = s.latitude - 1;
                    s.length = s.length + 1;
                }
            }
            return s;
        }

    }
}
