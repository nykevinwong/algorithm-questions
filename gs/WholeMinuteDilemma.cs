using System;
using System.Collections.Generic;

class WholeMinuteDilemma
{

    static int GetMinutePair(int[] minutes)
    {
        Dictionary<int,int> hashMap = new Dictionary<int, int>();
        double count  = 0;

        for(int i=0;i<minutes.Length;i++)
        {
            int value = minutes[i];
            if(value>=60) continue; // no pair can potentially exist for this value
            int key = 60-value;

            if(!hashMap.ContainsKey(key)) hashMap[key]=1;
            else hashMap[key]++;
        }

        for(int i=0;i<minutes.Length;i++)
        {
            int value = minutes[i];
            if(hashMap.ContainsKey(value) && hashMap[value]>0) 
            {
//                Console.Write("|{0,2}", value);
                hashMap[value]--;
                count+=0.5;
            }
        }

        Console.WriteLine();
        int c = (int)count;
        return c;
    }
    static void Main(string[] args)
    {
        int[] minutes = new int[] {10,40,20,60,50,23,35};
        Console.WriteLine(GetMinutePair(minutes));

        int[] minutes1 = new int[] {1,2,3,4,5,6};
        Console.WriteLine(GetMinutePair(minutes1));

        int[] minutes2 = new int[] {30,30,30,30,30,30,30};
        Console.WriteLine(GetMinutePair(minutes2));

        int[] minutes3 = new int[] {20,40,20,40,20};
        Console.WriteLine(GetMinutePair(minutes3));
    }
}