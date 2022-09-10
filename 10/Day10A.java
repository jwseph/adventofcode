import java.util.*;
import java.io.*;

public class Day10A {
    private static char getClosing(char c) throws Exception {
        // could have done this with ascii but switch is more readable
        switch (c) {
            case '(': return ')';
            case '[': return ']';
            case '{': return '}';
            case '<': return '>';
        }
        throw new Exception("Couldn't get closing bracket of "+c);
    }
    private static int getScore(char c) throws Exception {
        switch (c) {
            case ')': return 3;
            case ']': return 57;
            case '}': return 1197;
            case '>': return 25137;
        }
        throw new Exception("Couldn't get score of "+c);
    }
    private static boolean isClosing(char c) {
        return c == ')' || c == ']' || c == '}' || c == '>';
    }
    public static void main(String[] args) throws FileNotFoundException, Exception {
        Scanner in = new Scanner(new File("Day10.in"));
        
        int res = 0;
        while (in.hasNext()) {
            Stack<Character> s = new Stack<Character>();
            for (char c: in.next().toCharArray()) {
                if (!isClosing(c)) {
                    s.push(getClosing(c));
                    continue;
                }
                if (s.peek() == c) {
                    s.pop();
                    continue;
                }
                res += getScore(c);
                break;
            }
        }
        
        System.out.println(res);
    }
}
