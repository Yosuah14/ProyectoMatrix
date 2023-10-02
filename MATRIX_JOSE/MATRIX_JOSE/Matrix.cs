﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class Matrix
    {
        public string[,] matrix; // Atributo que es un array bidimensional de 15x15
        private string[] arrayDeStrings; // Atributo que es un array de string de 20 elementos

        // Constructor que toma argumentos para inicializar los atributos
        public Matrix(string[,] initialMatrix)
        {
            matrix = initialMatrix;

        }

        // Getter y Setter para el atributo 'matrix'
        public string[,] MatrixArray
        {
            get { return matrix; }
            set { matrix = value; }
        }

        // Getter y Setter para el atributo 'arrayDeStrings'
        public string[] ArrayDeStrings
        {
            get { return arrayDeStrings; }
            set { arrayDeStrings = value; }
        }
        /*
         * Metodo que de la lista de elegidos comprueba cual tiene la probabilidad de morir pone su nombre en nada para distingirlo
         * */
        public List<Personaje> EliminarCiu(List<Personaje> elegidos,Smith s,int conts,int contSmith)
        {
            int cont = 0;
            if (conts % 2 == 0&&contSmith==0)
            {
                for (int i = elegidos.Count - 1; i >= 0; i--)
                {
                    if (elegidos[i].latitude == s.latitude && elegidos[i].length == s.length && conts == 2)
                    {
                        elegidos.RemoveAt(i); // Utiliza RemoveAt para eliminar por índice
                        cont++;

                    }

                }
                Console.WriteLine("Han muerto " + cont + " personajes");
            }
            
            if(contSmith==1){
                for (int i = elegidos.Count - 1; i >= 0; i--)
                {

                    if (Personaje.SuperaPorcentajeMuerte(elegidos[i].deathPer))
                    {
                        elegidos.RemoveAt(i); // Utiliza RemoveAt para eliminar por índice
                        cont++;

                    }
                    else
                    {
                        elegidos[i].deathPer = elegidos[i].deathPer + 10;
                    }
                }
                Console.WriteLine("Han muerto " + cont + " personajes por el virus");
            }

           

            return elegidos;
        }
        public int contarMuertos(List<Personaje> elegidos)
        {

            int cont = 0;
            for (int i = elegidos.Count - 1; i >= 0; i--)
            {
                if (Personaje.SuperaPorcentajeMuerte(elegidos[i].deathPer))
                {
                    cont++;
                }
            }
           return cont;

        }

    }
}

