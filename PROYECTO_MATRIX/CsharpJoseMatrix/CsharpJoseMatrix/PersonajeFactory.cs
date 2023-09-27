using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace CsharpJoseMatrix
{
    public class PersonajeFactory
    {
        private string generarNombre()
        {
            string[] nombres = { "Michelle", "Alexander", "James", "Caroline", "Claire", "Jessica", "Erik", "Mike" };
            string nombre = nombres[RandomClass.numale(0, nombres.Length - 1)];
            return nombre;

        }
        private string generarCiudad()
        {
            string[] ciudades = { "Nueva York", "Boston", "Baltimore", "Atlanta", "Detroit", "Dallas", "Denver" };
            string ciudad = ciudades[RandomClass.numale(0, ciudades.Length - 1)];
            return ciudad;

        }
        private Personaje generarPersonaje(string[,] matrix)
        {
            int coden = 1000;
            int deathPer;
            string namep = generarNombre();
            string namec = generarCiudad();
            int age = RandomClass.numale(1, 75);
            if (namep.Equals("Smith") || namep.Equals("Neo"))
            {
                deathPer = 0;
            }
            else
            {
                deathPer = RandomClass.numale(10, 70);
            }
            int code = RandomClass.numale(1, coden);
            coden = code - 1;
            int length = RandomClass.numale(0, matrix.Length);
            int latitude = RandomClass.numale(0, matrix.Length);
            Personaje p = new Personaje(namep, namec, age, code, deathPer, length, latitude);
            return p;
        }
        public Personaje[] Generar200Personajes(string[,] matrix)
        {
            Personaje[] personajes = new Personaje[200];

            for (int i = 0; i < 200; i++)
            {
                Personaje personaje = generarPersonaje(matrix);
                personajes[i] = personaje;
            }

            return personajes;
        }
        public string[,] GenerarCIdsAleatorios(Personaje[] personajes)
        {

            string[,] cIdsAleatorios = new string[40, 4]; // Matriz de 40 filas y 4 columnas

            Random random = new Random();

            for (int i = 0; i < 40; i++)
            {
                int indiceAleatorio;
                do
                {
                    indiceAleatorio = random.Next(0, personajes.Length);
                } while (cIdsAleatorios.Cast<string>().Contains("C" + personajes[indiceAleatorio].Codigo));

                cIdsAleatorios[i, 0] = "C" + personajes[indiceAleatorio].code;
                cIdsAleatorios[i, 1] = personajes[indiceAleatorio].latitude.ToString();
                cIdsAleatorios[i, 2] = personajes[indiceAleatorio].length.ToString();
                cIdsAleatorios[i, 3] = personajes[indiceAleatorio].deathPer.ToString();
            }

            return cIdsAleatorios;
        }




    }


}

