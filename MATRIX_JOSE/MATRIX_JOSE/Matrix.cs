using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class Matrix
    {
        private string[,] matrix; // Atributo que es un array bidimensional de 15x15
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

}
}
