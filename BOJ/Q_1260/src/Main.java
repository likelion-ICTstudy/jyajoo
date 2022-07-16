import java.io.*;
import java.util.*;

public class Main {

    static int n, m, v;
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x - 1].add(y - 1);
            arr[y - 1].add(x - 1);
        }

        for (int i = 0; i < n; i++) {
            arr[i].sort(Comparator.naturalOrder());
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
            v = queue.remove();               // 맨 앞 원소 삭제 & 반환
            bw.write(v + 1 + " ");
            for (int i : arr[v]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int v) throws IOException {
        visited[v] = true;
        bw.write(v + 1 + " ");
        for (int i : arr[v]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}
