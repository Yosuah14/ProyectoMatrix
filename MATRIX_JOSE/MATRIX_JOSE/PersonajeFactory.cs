using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class PersonajeFactory
    {
        public static string generarNombre()
        {
            string[] nombres = { "Michelle", "Alexander", "James", "Caroline", "Claire", "Jessica", "Erik", "Mike" };
            string nombre = nombres[RandomClass.numale(0, nombres.Length - 1)];
            return nombre;

        }
        public static string generarCiudad()
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
          
            
            deathPer = RandomClass.numale(40,90);
            
            string code = "C"+ RandomClass.numale(100, coden).ToString();
            
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
            const int F1 = 40;
            const int C1 = 4;

            string[,] cIdsAleatorios = new string[F1, C1]; // Matriz de 40 filas y 4 columnas

            for (int i = 0; i < 40; i++)
            {
                // Verificar si cIdsAleatorios[i, 0] contiene el código del personaje
                if (cIdsAleatorios[i, 0] == null || !cIdsAleatorios[i, 0].Contains("C" + personajes[i].code))
                {
                    cIdsAleatorios[i, 0] = personajes[i].code;
                    cIdsAleatorios[i, 1] = personajes[i].latitude.ToString();
                    cIdsAleatorios[i, 2] = personajes[i].length.ToString();
                    cIdsAleatorios[i, 3] = personajes[i].deathPer.ToString();
                }
            }

            return cIdsAleatorios;
        }





    }
}


