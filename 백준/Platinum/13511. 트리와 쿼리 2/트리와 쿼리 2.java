import java.io.*;
import java.util.*;

public class Main {
    static int N, log;
    static List<int[]>[] tree;
    static int[][] parent;
    static int[] depth;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        log = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;

        tree = new ArrayList[N+1];
        parent = new int[N+1][log];
        depth = new int[N+1];
        dist = new long[N+1];

        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[u].add(new int[]{v,w});
            tree[v].add(new int[]{u,w});
        }

        depth[1] = 0;
        bfs();

        for (int j = 1; j < log; j++) {
            for (int i = 1; i <= N; i++) {
                parent[i][j] = parent[parent[i][j-1]][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        while(M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int lca = LCA(u, v);

            if (op == 1) {
                sb.append(dist[u] + dist[v] - 2*dist[lca]).append("\n");
            } else {
                int K = Integer.parseInt(st.nextToken());
                int d1 = depth[u] - depth[lca];
                int d2 = depth[v] - depth[lca];
                if (K <= d1 + 1) {
                    sb.append(kthAncestor(u, K-1)).append("\n");
                } else {
                    sb.append(kthAncestor(v, d2 - (K - (d1 +1)))).append("\n");
                }
            }
        }

        System.out.print(sb.toString());
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited();
        depth[1] = 0;
        dist[1] = 0;
        parent[1][0] = 1;

        boolean[] vis = new boolean[N+1];
        vis[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int[] nxt : tree[cur]) {
                if (!vis[nxt[0]]) {
                    vis[nxt[0]] = true;
                    depth[nxt[0]] = depth[cur] + 1;
                    dist[nxt[0]] = dist[cur] + nxt[1];
                    parent[nxt[0]][0] = cur;
                    q.offer(nxt[0]);
                }
            }
        }
    }

    static int LCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int tmp = u; u = v; v = tmp;
        }
        int diff = depth[u] - depth[v];
        for (int j = 0; j < log; j++) {
            if ((diff & (1<<j)) != 0) u = parent[u][j];
        }
        if (u == v) return u;

        for (int j = log-1; j >= 0; j--) {
            if (parent[u][j] != parent[v][j]) {
                u = parent[u][j];
                v = parent[v][j];
            }
        }
        return parent[u][0];
    }

    static int kthAncestor(int node, int k) {
        for (int j = 0; j < log; j++) {
            if ((k & (1<<j)) != 0) {
                node = parent[node][j];
            }
        }
        return node;
    }

    static void visited() {}
}
