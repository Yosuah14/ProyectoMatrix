using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
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
            int length = RandomClass.numale(0, 14);
            int latitude = RandomClass.numale(0, 14);
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

           

            for (int i = 0; i < 40; i++)
            {
                cIdsAleatorios[i, 0] = "C" + personajes[i].code;
                cIdsAleatorios[i, 1] = personajes[i].latitude.ToString();
                cIdsAleatorios[i, 2] = personajes[i].length.ToString();
                cIdsAleatorios[i, 3] = personajes[i].deathPer.ToString();
            }

            return cIdsAleatorios;
        }




    }
}
