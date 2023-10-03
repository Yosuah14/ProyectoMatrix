using MATRIX_JOSE;
using System.Collections.Generic;

int conts = 1;
int muertos = 0;
//Variables
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
smith = S.generarSmith(dimensiones);
List<Personaje> personajes;
List<Personaje> elegidos;
//Gnero todos los persoanjes e inizializo la matriz
personajes = p.Generar200Personajes();
elegidos = p.Generar30PersonajesAleatorios(personajes);
matrix = matrixf.InicializarMatrizConPersonajes(elegidos, neo, smith);
matrixf.ImprimirMatriz(matrix.MatrixArray);

do
{
    if ((elegidos.Count != 0))
    {
        //Cuento los muertos por el porcentaje de muerte
        muertos = matrix.contarMuertos(elegidos);
        //los elimino
        elegidos = matrix.EliminarCiu(elegidos, smith);
        //los regenero
        elegidos = p.RegenerarPersonajes(personajes, elegidos, muertos);
        if (conts % 2 == 0)
        {

            Console.ForegroundColor = ConsoleColor.Blue;
            Console.WriteLine("TURNO DE SMITH");
            Console.ResetColor();
            //Hago que se mueva smith
            smith = smith.movimientoSmith(neo, smith, elegidos, matrixf, matrix);
            //Inicializo e imprimo la matriz
            matrix = matrixf.InicializarMatrizConPersonajes(elegidos, neo, smith);
            matrixf.ImprimirMatriz(matrix.MatrixArray);
        }
        if (conts == 5 || conts == 10 || conts == 15 || conts == 20)
        {
            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("TURNO DE NEO");
            Console.ResetColor();
            if (neo.esElegido())
            {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("NEO ES ELEGIDO");
                Console.ResetColor();

            }
            neo = neo.moverNeo(neo);
            matrix = matrixf.InicializarMatrizConPersonajes(elegidos, neo, smith);
            matrixf.ImprimirMatriz(matrix.MatrixArray);

        }
        Thread.Sleep(1000);
        conts++;

    }
   

} while ((conts != 21) && (elegidos.Count != 0));
//Mensaje final para ver quien ha ganado el juego
if (elegidos.Count == 0)
{
    Console.WriteLine("MURIERON TODOS LOS PERSONAJES GANO SMITH...");
}
if (conts == 21 && elegidos.Count!=0)
{
    Console.WriteLine("GANO NEO EL TIEMPO SE ACABO Y SOBREVIVIERON CIUDADANOS");
}

