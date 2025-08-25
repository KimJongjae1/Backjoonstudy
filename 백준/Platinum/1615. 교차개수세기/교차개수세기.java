import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] tree;

    // ====== FastScanner: 문자열/토크나이저 객체 생성 방지 ======
    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            do { c = read(); } while (c <= ' ');   // skip space
            if (c == '-') { s = -1; c = read(); }
            while (c > ' ') { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        int M = fs.nextInt();

        tree = new int[4 * N + 5];

        // 입력: List<int[]>에 받되, 곧바로 배열로 복사해 ArrayList 오버헤드 제거
        List<int[]> list = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            list.add(new int[]{a, b}); // 원시타입 배열(박싱 없음)
        }

        // ArrayList 내부 버퍼 해제 유도
        int[][] arr = list.toArray(new int[M][]);
        list = null;
        System.gc(); // 🔸 입력 직후 큰 객체들 GC 유도 (너무 자주 호출 금지)

        // (a 오름차순, a가 같으면 b 오름차순) 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                if (x[0] != y[0]) return x[0] - y[0];
                return x[1] - y[1];
            }
        });

        System.gc(); // 🔸 정렬 과정의 임시 객체 정리 유도

        long ret = 0L;

        // 같은 a에서 자기들끼리 교차 집계 방지를 위해 b 오름차순 정렬 상태 유지
        for (int i = 0; i < M; i++) {
            int b = arr[i][1];
            if (b < N) ret += find(1, N, 1, b + 1, N);
            insert(1, N, 1, b);
        }

        System.out.println(ret);
    }

    public static void insert(int start, int end, int idx, int n) {
        if (start == end) {
            tree[idx]++;
            return;
        }
        int mid = (start + end) >>> 1;
        if (n <= mid) insert(start, mid, idx << 1, n);
        else          insert(mid + 1, end, idx << 1 | 1, n);
        tree[idx] = tree[idx << 1] + tree[idx << 1 | 1];
    }

    public static int find(int start, int end, int idx, int a, int n) {
        if (n < start || end < a) return 0;
        if (a <= start && end <= n) return tree[idx];
        int mid = (start + end) >>> 1;
        return find(start, mid, idx << 1, a, n)
             + find(mid + 1, end, idx << 1 | 1, a, n);
    }
}