using System;
using System.Text;
class ReverseEquaition
{
    public static string reverseEquation(string str) 
    { 
        // Resultant string 
        StringBuilder sb = new StringBuilder();
        char[] s = str.ToCharArray();
        int j = 0; 
        for (int i = 0; i < s.Length; i++) { 
            
            // A space marks the end of the word 
            if (s[i] == '+' || s[i] == '-' ||  
                s[i] == '/' || s[i] == '*') { 
                
                // insert the word at the begining 
                // of the result string 
//                result.insert(result.begin(),  
//                    s.begin() + j, s.begin() + i); 
                sb.Insert(0, s, j, i-j);
                j = i + 1; 
                
                // insert the symbol 
//               result.insert(result.begin(), s[i]); 
                sb.Insert(0, s, i, 1);
            } 
        } 
        
        // insert the last word in the string  
        // to the result string 
    //    result.insert(result.begin(), s.begin() + j,  
    //                                    s.end()); 
          sb.Insert(0, s, j, s.Length-j);  
        return sb.ToString(); 
    } 

    static void Main(string[] args)
    {
        Console.WriteLine(reverseEquation("20 - 3 + 5 * 2"));
        Console.WriteLine(reverseEquation("25 + 3 - 2 * 11"));
        Console.WriteLine(reverseEquation("a + b * c - d / e"));
    }

}

