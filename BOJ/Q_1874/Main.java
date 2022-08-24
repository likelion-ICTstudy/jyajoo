import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder result = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> numbers = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      numbers.add(Integer.parseInt(br.readLine()));
    }

    ArrayList<Integer> sortedNum = (ArrayList<Integer>) numbers.clone();
    sortedNum.sort(Comparator.naturalOrder());

    int push = 0;
    int pop = 0;

    while (true) {
      while (true) {
        if (push == n) {
          break;
        }
        if (sortedNum.get(push) > numbers.get(pop)) {
          break;
        } else {
          stack.add(sortedNum.get(push++));
          result.append("+").append("\n");
        }
      }

      if (stack.get(stack.size() - 1) == numbers.get(pop)) {
        stack.pop();
        result.append("-").append("\n");
        pop += 1;
        if (pop == n) {
          System.out.println(result);
          break;
        }
      } else {
        System.out.println("NO");
        break;
      }
    }
  }
}
