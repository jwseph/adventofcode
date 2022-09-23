public class LetterInventory {
    private int cnt[] = new int[26];
    private int sum = 0;
    private static char lower(char c) {
        // This is cooler than the method Character::toLowerCase
        return c < 'a' ? (char)(c-'A'+'a') : c;
    }
    private static boolean alpha(char c) {
        // Checks if character is in the range [a, z]
        return 'a' <= c && c <= 'z';
    }
    public LetterInventory(String s) {
        // Generate a LetterInventory which counts the number of each letter in the English alphabet. Non-letter characters in the String will be ignored.
        for (char c: s.toCharArray()) if (alpha(c = lower(c))) cnt[c-'a']++;
        for (char c = 'a'; c <= 'z'; c++) sum += cnt[c-'a'];
    }
    public int get(char c) throws IllegalArgumentException {
        // Get the count of a letter
        // Precondition: Character is a letter. Failure throws an IllegalArgumentException.
        if (!alpha(c = lower(c))) throw new IllegalArgumentException();
        return cnt[c-'a'];
    }
    public void set(char c, int n) {
        // Set the count of a letter
        // Precondition: Character is a letter. Failure throws an IllegalArgumentException.
        if (!alpha(c = lower(c))) throw new IllegalArgumentException();
        sum -= cnt[c-'a'];
        sum += cnt[c-'a'] = n;
    }
    public int size() {
        return sum;
    }
    public boolean isEmpty() {
        return sum == 0;
    }
    public String toString() {
        // Represents the count of each letter in a sorted string
        String s = "";
        for (char c = 'a'; c <= 'z'; c = (char)(c+1)) for (int i = 0; i < cnt[c-'a']; i++) s += c;
        return "["+s+"]";
    }
    public LetterInventory add(LetterInventory other) {
        // Returns a new LetterInventory with counts equal to the sum of those in this LetterInventory and the LetterInventory parameter.
        LetterInventory res = new LetterInventory("");
        for (char c = 'a'; c <= 'z'; c = (char)(c+1)) res.set(c, get(c)+other.get(c));
        return res;
    }
    public LetterInventory subtract(LetterInventory other) {
        // Returns a new LetterInventory with counts equal to the difference of those in this LetterInventory and the LetterInventory parameter.
        // When a negative count would be encountered, the function returns null.
        LetterInventory res = new LetterInventory("");
        for (char c = 'a'; c <= 'z'; c = (char)(c+1)) {
            int dif = get(c)-other.get(c);
            if (dif < 0) return null;
            res.set(c, dif);
        }
        return res;
    }
}
