import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashSet<String> strings = new HashSet<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            strings.add(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            String input = br.readLine();
            if (strings.contains(input)) {
                cnt += 1;
            }
        }

        bw.write(String.valueOf(cnt));

        bw.flush();
        br.close();
        bw.close();
    }
}
