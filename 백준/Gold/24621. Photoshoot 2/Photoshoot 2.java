import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        // A의 순서를 값→위치로 매핑(1-based OK)
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, i);
        }

        // B를 A에서의 위치열로 변환
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            int idx = map.get(n);
            arr[i] = idx;
        }

        // 오른쪽→왼쪽 스캔: 남길 수 있는 애들만 남기고 나머지는 왼쪽으로 당겨야 함
        int need = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] < need) {
                need = arr[i];
            } else {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}