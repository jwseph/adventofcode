import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;

public class Day12A {  // brute force (input length = 24)
    private static Map<String, List<String>> hash = new HashMap<String, List<String>>();
    private static Set<String> vst = new HashSet<String>();
    private static int res = 0;

    private static void dfs(String s) {
        if (s == "start") {
            res++;
            return;
        }
        if (vst.contains(s)) return;
        vst.add(s);
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Day12.in"));
        
        while (in.hasNext()) {
            String s[] = in.next().split("-");
            if (!hash.containsKey(s[1])) hash.put(s[1], new ArrayList<String>());
            hash.get(s[1]).add(s[0]);
        }
        
        dfs("end");
        System.out.println(res);
    }
}
