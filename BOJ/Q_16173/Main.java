import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];   // 모두 false로 초기화됨

        // n만큼 공백을 기준으로 이동가능 거리 입력받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, arr, visited);

        // 전역변수인 check가 true인지 확인
        if (check) {
            bw.write("HaruHaru");
        } else {
            bw.write("Hing");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int x, int y, int[][] arr, boolean[][] visited) {
        // 방문한 적이 있는지 확인
        if (visited[x][y]) {
            return ;
        }
        visited[x][y] = true;

        // 승리 지점에 도착했는지 확인
        if (arr[x][y] == -1) {
            check = true;
            return ;
        }

        // 이동가능한지 확인
        if (arr[x][y] + y < arr.length) {
            dfs(x, arr[x][y] + y, arr, visited);
        }

        if (arr[x][y] + x < arr.length) {
            dfs(arr[x][y] + x, y, arr, visited);
        }
    }
}
