using CsharpJoseMatrix;

MatrixFactory matrixf = new MatrixFactory();
string[,] dimensiones = new string[15, 15];
Matrix matrix = new Matrix(dimensiones);
PersonajeFactory p = new PersonajeFactory();
string[,] pCola;
Personaje[] pArray;
pArray = p.Generar200Personajes(dimensiones);
pCola = p.GenerarCIdsAleatorios(pArray);
matrix = matrixf.InicializarMatrizConPersonajes(pCola);
matrixf.ImprimirMatriz(matrix.MatrixArray);
