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
        private Personaje generarPersonaje()
        {
            int coden = 1000;
            int deathPer;
            string namep = generarNombre();
            string namec = generarCiudad();
            int age = RandomClass.numale(1, 75);
            deathPer = RandomClass.numale(30, 90);
            string code = "C" + RandomClass.numale(100, coden).ToString();
            int length = RandomClass.numale(0, 14);
            int latitude = RandomClass.numale(0, 14);
            Personaje p = new Personaje(namep, namec, age, code, deathPer, length, latitude);
            return p;
        }
        /*
         * Metodo que genera personajes en una lista
         * */
        public List<Personaje> Generar200Personajes()
        {
            List<Personaje> personajes = new List<Personaje>();

            for (int i = 0; i < 200; i++)
            {
                Personaje personaje = generarPersonaje();
                personajes.Add(personaje);
            }

            return personajes;
        }
        /*
         * Metodo que de una lista de 200 personajes saca aleatoriamente 30 de ellos y los mete en una lista aparte
         * */
        public List<Personaje> Generar30PersonajesAleatorios(List<Personaje> personajes200)
        {
           

            Random rand = new Random();
            List<Personaje> personajesAleatorios = new List<Personaje>();

            for (int i = 0; i < 30; i++)
            {

                // Generar un índice aleatorio dentro del rango de la lista de 200 personajes
                int indiceAleatorio = rand.Next(personajes200.Count);

                // Obtener el personaje aleatorio y agregarlo a la lista de personajes aleatorios
                Personaje personajeAleatorio = personajes200[indiceAleatorio];
                personajesAleatorios.Add(personajeAleatorio);


                // Eliminar el personaje de la lista original
                personajes200.RemoveAt(indiceAleatorio);
            }

            return personajesAleatorios;
        }
        /*
         * Metodo que una vez se mueran los de la matriz de elegidos mete los restantes hasta llegar otra vez a 30
         * */

        public List<Personaje> RegenerarPersonajes(List<Personaje> personajes200, List<Personaje> elegidos,int cont)
        {

            Random rand = new Random();
            

            for (int i = 0; i < cont; i++)
            {
                int indiceAleatorio = rand.Next(personajes200.Count);


                // Generar un índice aleatorio dentro del rango de la lista de 200 personajes
                if (indiceAleatorio!=0)
                {
                    Personaje personajeAleatorio = personajes200[indiceAleatorio];
                    elegidos.Add(personajeAleatorio);


                    // Eliminar el personaje de la lista original
                    personajes200.RemoveAt(indiceAleatorio);

                }

                // Obtener el personaje aleatorio y agregarlo a la lista de personajes aleatorios

            }

            return elegidos;

        }






    }
}


