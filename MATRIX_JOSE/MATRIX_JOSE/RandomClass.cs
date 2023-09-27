using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MATRIX_JOSE
{
    public class RandomClass
    {
        public static int numale(int min, int max)
        {
            Random random = new Random();
            return random.Next(min, max);
        }

    }
}
