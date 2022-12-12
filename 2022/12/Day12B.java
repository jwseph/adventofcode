import java.util.*;
import java.io.*;

public class Day12B {
    private static int compare(List<Integer> a, List<Integer> b) {
        return Integer.compare(a.get(2), b.get(2));
    }
    private static int bfs(char arr[][], int s_r, int s_c, int e_r, int e_c) {
        int nr = arr.length, nc = arr[0].length;
        int dst[][] = new int[nr][nc];
        boolean vst[][] = new boolean[nr][nc];
        for (int r = 0; r < nr; r++) for (int c = 0; c < nc; c++) {
            dst[r][c] = Integer.MAX_VALUE;
        }

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Day12B::compare);
        pq.add(Arrays.asList(s_r, s_c, 0));
        while (!pq.isEmpty()) {
            List<Integer> x = pq.remove();
            int r = x.get(0), c = x.get(1), d = x.get(2);
            if (vst[r][c]) continue;
            vst[r][c] = true;
            dst[r][c] = Math.min(dst[r][c], d);
            if (r-1 >= 0) pq.add(Arrays.asList(r-1, c, dst[r][c]+(arr[r-1][c] <= arr[r][c]+1 ? 1 : 1000000)));
            if (r+1 < nr) pq.add(Arrays.asList(r+1, c, dst[r][c]+(arr[r+1][c] <= arr[r][c]+1 ? 1 : 1000000)));
            if (c-1 >= 0) pq.add(Arrays.asList(r, c-1, dst[r][c]+(arr[r][c-1] <= arr[r][c]+1 ? 1 : 1000000)));
            if (c+1 < nc) pq.add(Arrays.asList(r, c+1, dst[r][c]+(arr[r][c+1] <= arr[r][c]+1 ? 1 : 1000000)));
        }
        return dst[e_r][e_c];
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("Day12.in"));
        
        List<String> lines = new ArrayList<String>();
        while (in.hasNext()) lines.add(in.next());
        int nr = lines.size(), nc = lines.get(0).length();
        char arr[][] = new char[nr][nc];
        List<List<Integer>> s_rc = new ArrayList<>();
        int e_r = -1, e_c = -1;
        for (int r = 0; r < nr; r++) for (int c = 0; c < nc; c++) {
            arr[r][c] = lines.get(r).charAt(c);
            if (arr[r][c] == 'S' || arr[r][c] == 'a') {
                s_rc.add(Arrays.asList(r, c));
                arr[r][c] = 'a';
            }
            if (arr[r][c] == 'E') {
                e_r = r;
                e_c = c;
                arr[r][c] = 'z';
            }
        }

        int res = Integer.MAX_VALUE;
        for (List<Integer> rc: s_rc) {
            res = Math.min(res, bfs(arr, rc.get(0), rc.get(1), e_r, e_c));
        }
        System.out.println(res);
    }
}