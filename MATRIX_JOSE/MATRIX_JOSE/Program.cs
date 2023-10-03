using MATRIX_JOSE;
using System.Collections.Generic;

int conts=1;
int muertos = 0;

Neo neo;
Smith smith;
NeoFactory n = new NeoFactory();
SmithFactory S = new SmithFactory();
const int FILAS = 15;
const int COLUMNAS = 15;
string[,] dimensiones = new string[FILAS, COLUMNAS];
MatrixFactory matrixf = new MatrixFactory();
Matrix matrix = new Matrix(dimensiones);
PersonajeFactory p = new PersonajeFactory();
neo = n.generarNeo(dimensiones);
smith=S.generarSmith(dimensiones);
List<Personaje> personajes;
List<Personaje> elegidos;
personajes = p.Generar200Personajes();
elegidos = p.Generar30PersonajesAleatorios(personajes);
matrix = matrixf.InicializarMatrizConPersonajes(elegidos,neo,smith);
matrixf.ImprimirMatriz(matrix.MatrixArray);

do
{
     muertos = matrix.contarMuertos(elegidos);
     elegidos = matrix.EliminarCiu(elegidos,smith,conts);
     elegidos = p.RegenerarPersonajes(personajes, elegidos, muertos);
   //  matrix = matrixf.InicializarMatrizConPersonajes(elegidos, neo, smith);
   //  matrixf.ImprimirMatriz(matrix.MatrixArray);
    if (conts%2==0)
    {
        Console.WriteLine("TURNO DE SMITH");
        smith = smith.movimientoSmith(neo, smith, elegidos, matrixf, matrix);
        //muertos = matrix.contarMuertos(elegidos);
     

        matrix = matrixf.InicializarMatrizConPersonajes(elegidos, neo, smith);
        matrixf.ImprimirMatriz(matrix.MatrixArray);

    }      
    if (conts == 5|| conts == 10 || conts == 15 || conts == 20)
    {
        Console.WriteLine("TURNO DE NEO");
        if (neo.esElegido())
        {
            Console.WriteLine("NEO ES ELEGIDO");
        }
        neo = neo.moverNeo(neo);
        matrix = matrixf.InicializarMatrizConPersonajes(elegidos, neo, smith);
        matrixf.ImprimirMatriz(matrix.MatrixArray);

    }
    Thread.Sleep(1000);
    conts++;
    
} while (conts!=21&&(personajes.Count!=1&&elegidos.Count!=1));

if (personajes.Count == 0&&elegidos.Count==0)
{
    Console.WriteLine("MURIERON TODOS LOS PERSONAJES GANO SMITH...");
}
if (conts == 21)
{
    Console.WriteLine("GANO NEO EL TEIMPO SE ACABO Y SOBREVIVIERON CIUDADANOS");
}

