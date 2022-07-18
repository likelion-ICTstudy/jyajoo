import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    static int n, m, v;
    static int[][] graph;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x - 1][y - 1] = 1;
            graph[y - 1][x - 1] = 1;
        }

        dfs(v - 1);
        bw.write("\n");
        visited = new boolean[n];
        bfs(v - 1);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int v) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            v = queue.remove();
            bw.write(v + 1 + " ");
            for (int i = 0; i < n; i++) {
                if (graph[v][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int v) throws IOException {
        visited[v] = true;
        bw.write(v + 1 + " ");
        for (int i = 0; i < n; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
