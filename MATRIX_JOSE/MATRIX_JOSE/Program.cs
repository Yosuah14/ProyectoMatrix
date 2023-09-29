using MATRIX_JOSE;
using System.Collections.Generic;
int cont=0;
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
elegidos = p.Generar30PersonajesAleatorios(personajes,elegidos);
matrix = matrixf.InicializarMatrizConPersonajes(elegidos,neo,smith);
matrixf.ImprimirMatriz(matrix.MatrixArray);


