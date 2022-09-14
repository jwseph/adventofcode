import java.util.*;
import java.io.*;

public class Day18A2 {
    // private static List<Character> s = new ArrayList<Character>();
    // private static int split(int i, int d) {
    //     int k = 0;
    //     for (int j = i; j >= 0; j--) {
    //         if (s.get(j) == '[') {
    //             d--;
    //         } else if (s.get(j) == ']') {
    //             d++;
    //         } else if ('0' <= s.get(j) && s.get(j) <= '9') {
    //             int v = s.get(i)-'0'+s.get(j)-'0';
    //             if (v > 9) k += explode(j, d, v);
    //         }
    //     }
    // }
    // private static int explode(int i, int d, int v) {
    //     int k = 0;
    //     s.remove(i);
    //     s.add(i, '[');
    //     s.add(i, (char)(v/2+'0'));
    //     s.add(i, ',');
    //     s.add(i, (char)(v-v/2+'0'));
    //     s.add(i, ']');
    //     k += 4;
    //     d++;
    //     if (d > 4) k += split(i, d);
    //     return k;
    // }
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner in = new Scanner(new File("Day18.in"));
        
        // String str = in.next();
        // while (in.hasNext()) str = "["+str+","+in.next()+"]";
        // for (char c: str.toCharArray()) s.add(c);

        // int d = 0;
        // for (int i = 0; i < s.size(); i++) {
        //     if (s.get(i) == '[') {
        //         d++;
        //         return;
        //     }
        //     if (s.get(i) == ']') {
        //         if (d > 4) split(i-4, d);
        //         d--;
        //         return;
        //     }
        // }
    }
}
