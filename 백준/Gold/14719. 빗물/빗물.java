import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] h = new int[W];
        for (int i = 0; i < W; i++) h[i] = Integer.parseInt(st.nextToken());

        if (W < 3) { System.out.println(0); return; }

        int l = 0, r = W - 1;
        int maxL = h[l], maxR = h[r];
        int ans = 0;

        while (l < r) {
            if (maxL <= maxR) {
                l++;
                if (l >= r) break;
                maxL = Math.max(maxL, h[l]);
                ans += Math.max(0, maxL - h[l]);
            } else {
                r--;
                if (l >= r) break;
                maxR = Math.max(maxR, h[r]);
                ans += Math.max(0, maxR - h[r]);
            }
        }
        System.out.println(ans);
    }
}