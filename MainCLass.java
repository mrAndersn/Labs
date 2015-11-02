import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


/**
 * Created by Andrew on 18.09.2015.
 */
public class MainCLass {

    static void printArray(Object... args)
    {
        for(Object obj : args)
        {
            System.out.print(obj + " ");

        }
        System.out.println();
    }

    public  static void main(String[] args)
    {
        printArray(new Object[]{
                new Integer(47), new Float(3.14), new Double(11.11)
        });

        printArray(new Object[]{"one", "two", "three"});
        printArray(new Object[]{new A(), new A(), new A()});
        printArray((Object[])new Integer[]{1,2,3,4,5});
        printArray();

    }
}
