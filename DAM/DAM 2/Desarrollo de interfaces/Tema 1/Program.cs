// See https://aka.ms/new-console-template for more information

public static class funciones
{
    public static bool esPrimo(int a)
    {
        int cont = 0;

        for (int i = 1; i < a; i++)
        {
            if ((a % i) == 0)
            {
                cont++;
            }


        }
        if (cont < 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

class programa
{
    static void Main()
    {
        int num;
        Console.WriteLine("Introduce un numero");
        num=int.Parse(Console.ReadLine());
        
        if(funciones.esPrimo(num)==true) {
            Console.WriteLine("El numero es primo");
        }
        else
        {
            Console.WriteLine("El numero no es primo");
        }

    }
}


