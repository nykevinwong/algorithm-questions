
using System;
using System.Collections.Generic;

class MinPriceDifferenceStock
{
    static void Main(string[] args)
    {
        // assume below 3 arrays have the same size
        int[] startPrice = new int[]{10,20,30,40,50,60,70,80};
        int[] endPrice = new int[]{15,28,32,49,49,51,63,89};
        int[] ids = new int[]{1,2,3,4,5,6,7,8};

        int minPriceDiff = int.MaxValue; int minIndex = -1;

        for(int i=0;i<startPrice.Length;i++)
        {
            int curPriceDiff = Math.Abs(endPrice[i]-startPrice[i]);

            if(minPriceDiff > curPriceDiff)
            {
                minPriceDiff = curPriceDiff;
                minIndex = i;
            }
        }

        Console.WriteLine("Min Price Diff: {0} => ID:{1}, start:{2}, end:{3}", minPriceDiff, ids[minIndex], startPrice[minIndex], endPrice[minIndex] );
    }
}