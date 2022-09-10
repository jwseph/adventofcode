import java.util.*;
import java.io.*;

public class Day8A {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Day8.in"));
        
        int t = 0, res = 0;
        while (in.hasNext()) {
            String s = in.next();
            int n = s.length();
            if (t --> 0 && (n <= 4 || n == 7)) res++;
            if (s.equals("|")) t = 4;
        }
        
        System.out.println(res);
    }
}
