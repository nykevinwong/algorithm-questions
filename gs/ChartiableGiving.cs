
using System;
using System.Collections.Generic;

class ChartiableGiving
{
    class Charity
    {
        public int value;
        public string label; 
        public Charity() {}
        public Charity(string label, int value) { this.label = label; this.value = value;}
    }

    static int CompareCharity(Charity a, Charity b)
    {
        if(a.value==b.value)
            return a.label.CompareTo(b.label);

        return a.value - b.value;
    }

    static void Main(string[] args)
    {
        // assume money.length = charity.length
        int[] money = new int[]{25,8,2,35,15,120,55,42,42};
        string[] charity= new string[]{"A","B","C","C","B","B","A","C","B"};        
        Charity[] charities = new Charity[money.Length];

        for(int i=0;i<money.Length;i++)
            charities[i] = new Charity(charity[i], money[i]);
 
        Array.Sort(charities, new Comparison<Charity>(CompareCharity));

        Console.WriteLine("the order:");
        for(int i=0;i< charities.Length;i++)
        Console.Write("|{0}:{1,2}", charities[i].label, charities[i].value);
    }
}