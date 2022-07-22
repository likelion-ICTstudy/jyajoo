import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<String> subject = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            String[] email = br.readLine().split("Re: ");
            if (!subject.contains(email[email.length - 1])) {
                subject.add(email[email.length - 1]);
                cnt.add(email.length);
            } else {
                int idx = subject.indexOf(email[email.length - 1]);
                if (cnt.get(idx) < email.length) {
                    cnt.set(idx, cnt.get(idx) + (email.length - cnt.get(idx)));
                }
            }
        }
        int result = 0;
        for (int i : cnt) {
            result += i;
        }
        if (result <= n) {
            bw.write("YES");
        }else{
            bw.write("NO");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
