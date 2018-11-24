package test;

import java.util.HashMap;

public class CoderFriend {

    public static String winner(char[] erica, char[] bob)
    {
        HashMap<Character, Integer> scoreTable = new HashMap<Character, Integer>();
        scoreTable.put('S', 0);
        scoreTable.put('E', 1);
        scoreTable.put('M', 3);
        scoreTable.put('H', 5);

        // assume arrays erica and bob has the same length
        int eScore = 0;
        int bScore = 0;

        for(int i=0;i<erica.length;i++)
        {
            char e = erica[i];
            eScore += scoreTable.get(e);
            char b = bob[i];
            bScore += scoreTable.get(b);
        }

        System.out.printf("\nErcis:%d  , bob: %d \n", eScore, bScore);
        if(eScore > bScore) return "Ercia";
        if(eScore == bScore) return "Tie";

        return "Bob";
    }

    public static void main(String[] args) {


        System.out.println( winner(new char[]{'E','H','H'}, new char[]{'E','M','E'}) );
        System.out.println( winner(new char[]{'E','H','E'}, new char[]{'E','M','M'}) );
        System.out.println( winner(new char[]{'E','H','E'}, new char[]{'E','M','H'}) );
        System.out.println("MatrixWalk");
    }

}
