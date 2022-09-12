import java.util.*;
import java.io.*;

public class Day17A {
    private static int x1, x2, y1, y2;
    private static int getT(int xv) {  // add support for multiple t from one xv later
        int x = 0, t;
        for (t = 0; xv > 0 && x < x1; t++) {
            x += xv;
            xv--;
        }
        return (x1 <= x && x <= x2) ? t : -1;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Day17.in")).useDelimiter("[^\\-0-9]+");
        
        x1 = in.nextInt();
        x2 = in.nextInt();
        y1 = in.nextInt();
        y2 = in.nextInt();
        
        Map<Integer, Integer> ts = new HashMap<Integer, Integer>();  // valid number of frames, x velocity
        for (int xv = x1; xv > 0; xv--) {
            int t = getT(xv);
            if (t != -1) ts.put(t, xv);
        }
        
        for (Map.Entry<Integer, Integer> t: ts.entrySet())
            System.out.println(t.getKey()+" "+t.getValue());
        System.out.println();
        
        int res = Integer.MIN_VALUE;
        for (int t: ts.keySet()) {
            for (int yv = y1; yv < 2*(y2-y1+t); yv++) {
                int y = -t*(t+1)/2+yv*t;
                int my = 0;
                if (yv > 0) {
                    int t_ = (2*yv-1)/2;
                    my = -t_*(t_+1)/2+yv*t_;
                }
                // int my = (yv < 0) ? 0 : (2*yv-1)/2;
                if (y1 <= y && y <= y2) res = Math.max(res, my);
                if (y1 <= y && y <= y2) {
                    System.out.println(ts.get(t)+", "+yv);
                    System.out.println(my);
                }
            }
        }
        
        System.out.println(res);
    }
}
