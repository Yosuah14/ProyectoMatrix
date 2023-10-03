using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class MatrixFactory
    {
        public void ImprimirMatriz(string[,] matriz)
        {
            for (int i = 0; i < matriz.GetLength(0); i++)
            {
                for (int j = 0; j < matriz.GetLength(1); j++)
                {
                    if (matriz[i, j] != null && (matriz[i, j].Contains('C') || matriz[i, j].Contains('S') || matriz[i, j].Contains('N')))
                    {
                        Console.Write("[" + matriz[i, j] + "]"); // Imprimir "." si no hay un personaje en esa posición
                        Console.Write("   ");
                    }
                    else
                    {
                        Console.Write("[" + matriz[i, j] + "]"); // Imprimir "." si no hay un personaje en esa posición
                        Console.Write("       ");
                    }

                }
                Console.WriteLine();
            }
            Console.WriteLine();
            Console.WriteLine();
        }
        /*
         * Metodo que mediante una lista de elegidos mete el codigo en la matrix de matrix para que pueda ser imrpimido
         * 
         * */

        public Matrix InicializarMatrizConPersonajes(List<Personaje> personajes200, Neo neo, Smith smith)
        {
            string[,] matrix = new string[15, 15];

            foreach (var personaje in personajes200)
            {
                int latitude = personaje.latitude;
                int longitud = personaje.length;
                matrix[latitude, longitud] = personaje.code;
            }
            matrix[neo.latitude, neo.length] = neo.namep;
            matrix[smith.latitude, smith.length] = smith.namep;

            return new Matrix(matrix);
        }




    }
}
