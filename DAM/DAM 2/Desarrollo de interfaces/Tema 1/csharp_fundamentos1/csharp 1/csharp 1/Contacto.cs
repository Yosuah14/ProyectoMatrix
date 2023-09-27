using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csharp_1
{

    public class Contacto


    {
        string nombre, apellidos, movil, fijo;
        public Contacto(string nombre, string apellidos, string movil)
        {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.movil = movil;

        }
        public Contacto(string nombre, string apellidos, string movil, string fijo) : this(nombre, apellidos, movil)
        {
            this.fijo = fijo;
        }
        public string Nombre
        {
            set { this.nombre = value; }
            get
            { return this.nombre; }
        }
    }
}
