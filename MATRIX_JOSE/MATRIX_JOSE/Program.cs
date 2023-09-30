using MATRIX_JOSE;
using System.Collections.Generic;
int cont=0;
int conts=0;
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
    elegidos = matrix.EliminarCiu(elegidos);
    elegidos = p.RegenerarPersonajes(personajes, elegidos, muertos);
    matrix = matrixf.InicializarMatrizConPersonajes(elegidos, neo, smith);
    matrixf.ImprimirMatriz(matrix.MatrixArray);
    if (conts % 2==0)
    {
        neo = neo.moverNeo(neo);
        matrix = matrixf.InicializarMatrizConPersonajes(elegidos, neo, smith);
        matrixf.ImprimirMatriz(matrix.MatrixArray);

    }
    Thread.Sleep(1000);
    conts++;

} while (conts!=20);

