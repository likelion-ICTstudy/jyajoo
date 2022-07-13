import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    static boolean check = false;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];   // 모두 false로 초기화됨

        // n만큼 공백을 기준으로 이동가능 거리 입력받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

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

    static void dfs(int x, int y) {
        /*
        // 이동가능한지, 방문한 적이 있는지, 승리지점인지 확인
        if (x >= arr.length || y >= arr.length) {
            return ;
        } else if (visited[x][y]) {
            return ;
        } else if (arr[x][y] == -1) {
            check = true;
            return ;
        }

        visited[x][y] = true;

        dfs(x, arr[x][y] + y);
        dfs(arr[x][y] + x, y);
         */

        if (arr[x][y] == -1) {
            check = true;
            return ;
        }

        visited[x][y] = true;

        // 이동가능한지 확인
        if (arr[x][y] + y < arr.length) {
            if (!visited[x][arr[x][y] + y]) {
                dfs(x, arr[x][y] + y);
            }
        }

        if (arr[x][y] + x < arr.length) {
            if (!visited[arr[x][y] + x][y]) {
                dfs(arr[x][y] + x, y);
            }
        }

    }
}