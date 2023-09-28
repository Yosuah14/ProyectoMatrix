using MATRIX_JOSE;
Neo neo;
Smith smith;
NeoFactory n = new NeoFactory();
SmithFactory S = new SmithFactory();


MatrixFactory matrixf = new MatrixFactory();
string[,] dimensiones = new string[15, 15];
Matrix matrix = new Matrix(dimensiones);
PersonajeFactory p = new PersonajeFactory();
neo = n.generarNeo(dimensiones);
smith=S.generarSmith(dimensiones);
string[,] pCola;
Personaje[] pArray;
pArray = p.Generar200Personajes(dimensiones);
pCola = p.GenerarCIdsAleatorios(pArray);
matrix = matrixf.InicializarMatrizConPersonajes(pCola,neo,smith);
matrixf.ImprimirMatriz(matrix.MatrixArray);
matrix.MatrixArray= matrix.eliminarCiu(matrix.MatrixArray,pCola);
matrixf.ImprimirMatriz(matrix.MatrixArray);

