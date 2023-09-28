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
                    if (matriz[i, j] != null && matriz[i, j].Contains('C'))
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
        }

        public Matrix InicializarMatrizConPersonajes(string[,] matriz, Neo neo, Smith smith)
        {

            string[,] matrix = new string[15, 15];

            for (int i = 0; i < matriz.GetLength(0); i++)
            {
                int latitude = int.Parse(matriz[i, 1]);
                int longitud = int.Parse(matriz[i, 2]);
                matrix[latitude, longitud] = matriz[i, 0];
                
            }
            matrix[neo.latitude, neo.length]= "NEOO";
            matrix[smith.latitude, smith.length] = "SMTH";

            return new Matrix(matrix);
        }
    }
}
