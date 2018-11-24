package test;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public static String removeComments(String[] source) {
        boolean inComment = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList();
        for (String line: source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inComment) newline = new StringBuilder();
            while (i < line.length()) {
                if (!inComment && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inComment = true;
                    i++;
                } else if (inComment && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inComment = false;
                    i++;
                } else if (!inComment && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!inComment) {
                    newline.append(chars[i]);
                }
                i++;
            }
            if (!inComment && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s : ans)
        {
            sb.append(s+"\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String[] testData = new String[] {"/*Test program */",
                "int main()", "{ ", "  // variable declaration ",
                "int a, b, c;", "/* This is a test", "   multiline  ",
                "   comment for ", "   testing */", "a = b + c;", "}"};

        System.out.print( removeComments(testData) );
    }

    }
