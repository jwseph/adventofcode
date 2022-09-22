import java.util.*;

public class LetterInventory {
    private int cnt[] = new int[26];
    private static char lower(char c) {
        return c < 'a' ? (char)(c-'A'+'a') : c;
    }
    private static boolean alpha(char c) {
        return 'a' <= c && c <= 'z';
    }
    public LetterInventory(String s) {
        for (char c: s.toCharArray()) {
            c = lower(c);
            if (alpha(c)) cnt[c-'a']++;
        }
    }
    public int get(char c) throws IllegalArgumentException {
        c = lower(c);
        if (!alpha(c)) throw new IllegalArgumentException();
        return cnt[c-'a'];
    }
    public void set(char c, int n) {
        c = lower(c);
        if (!alpha(c)) throw new IllegalArgumentException();
        cnt[c-'a'] = n;
    }
    public String toString() {
        String s = "";
        for (char c = 'a'; c <= 'z'; c = (char)(c+1)) for (int i = 0; i < cnt[c-'a']; i++) s += c;
        return s;
    }
    public LetterInventory add(LetterInventory other) {
        LetterInventory res = new LetterInventory("");
        for (char c = 'a'; c <= 'z'; c = (char)(c+1)) res.set(c, get(c)+other.get(c));
        return res;
    }
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory res = new LetterInventory("");
        for (char c = 'a'; c <= 'z'; c = (char)(c+1)) {
            int dif = get(c)-other.get(c);
            if (dif < 0) return null;
            res.set(c, dif);
        }
        return res;
    }
}
