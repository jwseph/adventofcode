import java.util.*;
import java.io.*;

public class Day1B {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Day1.in"));
        
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        int sum = a+b+c;
        int res = 0;
        while (in.hasNextInt()) {
            int lastSum = sum;
            sum -= a;
            a = b;
            b = c;
            c = in.nextInt();
            sum += c;
            if (sum > lastSum) res++;
        }
        
        System.out.println(res);
    }
}
