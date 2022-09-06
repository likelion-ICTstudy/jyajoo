import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    List<Integer> numList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      numList.add(Integer.parseInt(st.nextToken()));
    }
    int k = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i += n / k) {
      numList.subList(i, i + n / k).sort(Comparator.naturalOrder());
    }

    for (int i : numList) {
      System.out.print(i + " ");
    }
  }
}
