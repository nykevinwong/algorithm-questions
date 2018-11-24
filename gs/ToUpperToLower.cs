using System;
using System.Collections.Generic;

class ToUpperToLower
{

    static string ToUpperLower(string str)
    {
        if(str==null) return "";
        char[] cArray = str.ToCharArray();

        for(int i=0;i<cArray.Length;i++)
        {
            char c = cArray[i];
            if(c >=65 && c <=90) cArray[i]+= (char)32;
            else if(c >= 97 && c <= 122) cArray[i]-=(char)32;
        }

        return new String(cArray);
    }

    static void Main(string[] args)
    {
        Console.WriteLine(ToUpperLower("GoldManSca"));
        Console.WriteLine(ToUpperLower("aBcDeFgHi"));
        Console.WriteLine(ToUpperLower("abcdeefg"));
        Console.WriteLine(ToUpperLower("ABCDE32323abcdef"));
        Console.WriteLine(ToUpperLower(""));
    }
}