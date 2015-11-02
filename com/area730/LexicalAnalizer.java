package com.area730;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Andrew on 23.09.2015.
 */
public class LexicalAnalizer {

    public enum Token
    {
        KEYWORD, IDENTIFIER, OPERATOR, CONSTANT, SYMBOL, BLANK, INTEGER, REAL, BOOLEAN, CHARACTER, STRING, LBRACKET, RBRACKET, VAR, COLON, SEMICOLON, DOUBLECOLON
    }






    public static void main(String[] args) throws IOException
    {
        String content = readFile("D:\\Andrew\\Java\\1.txt", StandardCharsets.UTF_8);
        makeTokens(content);

    }

    private static void makeTokens(String content)
    {
        int curLine;
        int state = 0;
        String curToken = "";
        boolean inToken = false;


        for (int i = 0; i < content.length(); i++)
        {
            if(state == 0)
            {
                if(content.charAt(i) != ' ')
                {
                    state = 1;
                }
            }

            else if(state == 1)
            {
                if (content.charAt(i) == ' ')
                {
                    state = 1;
                }
                else
                {
                    inToken = true;
                    curToken += content.charAt(i);

                }
            }

        }
    }



    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
