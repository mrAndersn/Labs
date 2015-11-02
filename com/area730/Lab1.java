package com.area730;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Andrew on 21.09.2015.
 */
public class Lab1 {



    public static void main(String[] args) throws IOException
    {

        String str = getNewText();
        System.out.println(str);

    }

    static String getNewText() throws IOException
    {
        String content = readFile("D:\\Andrew\\Java\\2.txt", StandardCharsets.UTF_8);
        String s = "";

        int state = 0;
        for(int i = 0; i < content.length(); i++)
        {
            if(state == 0)
            {
                char curChar = content.charAt(i);
                if(curChar == '"')
                {
                    s += curChar;
                    state = 1;
                }

                else if(curChar == '/')
                {
                    state = 3;
                }

                else if(curChar == '\'')
                {
                    s += curChar;
                    state = 7;
                }
                else {
                    s += curChar;
                }
            }

            else if (state == 1)
            {
                char curChar = content.charAt(i);
                s += curChar;
                if(curChar == '\\')
                {
                    state = 2;
                }
                else if(curChar == '"')
                {
                    state = 0;
                }

            }

            else if(state == 2)
            {
                char curChar = content.charAt(i);
                s += curChar;
                state = 1;
            }


            else if (state == 3)
            {
                char curChar = content.charAt(i);
                if(curChar == '/')
                {
                    state = 4;
                }

                else if(curChar == '*')
                {
                    state = 5;
                }

                else
                {
                    state = 0;
                }
            }

            else if(state == 4)
            {
                char curChar = content.charAt(i);
                if(curChar == '\n')
                {
                    s += '\n';
                    state = 0;

                }
            }

            else if(state == 5)
            {
                char curChar = content.charAt(i);

                if(curChar == '*')
                {
                    state = 6;
                }
            }

            else if(state == 6)
            {
                char curChur = content.charAt(i);

                if(curChur == '/')
                {
                    state = 0;
                }

                else if(curChur == '*')
                {
                    state = 6;
                }

                else
                {
                    state = 5;
                }
            }

            else if(state == 7)
            {
                char curChar = content.charAt(i);
                s += curChar;

                if(curChar == '\'')
                {
                    state = 0;
                }
            }
        }

        return s;
    }

    static String readFile(String path, Charset encoding) throws IOException

    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);

    }
}
