package com.area730;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*sdfgsdfg//dgfd
dfgdfgdf
;dr"ui* /fdgkj
dfglkjdfl /

 ***/

public class Main {

    public static void main(String[] args) throws IOException
    {
        String content = readFile("D:\\Andrew\\Java\\1.txt", StandardCharsets.UTF_8);
        String s = ""; //creating an empty string

        boolean inQuotes = false;

        for(int i = 0; i < content.length(); i++)
        {
            char c = content.charAt(i);
            if(c == '"')
            {
                if(inQuotes)
                {
                    System.out.println(s);
                    s = "";
                }
                inQuotes = !inQuotes;
                continue;
            }

            if(inQuotes)
            {
                s += c;

            }//adding to a string


        }

        System.out.println("dfgf//fdgdfgdfgdf /*yo,man*/");
    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}


/* Output:

 *///:~




