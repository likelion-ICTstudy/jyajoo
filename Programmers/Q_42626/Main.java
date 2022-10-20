import java.util.PriorityQueue;

class Solution {
  public int solution(int[] scoville, int K) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int cnt = 0;

    for (int i = 0; i < scoville.length; i++) {
      heap.add(scoville[i]);
    }

    while (heap.size() >= 2) {
      Integer min = heap.poll();
      if (min >= K) {
        return cnt;
      }
      cnt += 1;
      Integer min2 = heap.poll();
      heap.add(min + min2 * 2);
    }
    Integer min = heap.poll();
    if (min >= K) {
      return cnt;
    } else {
      return -1;
    }
  }
}

public class Main {

  public static void main(String[] args) {
    int [] scoville = {1, 2, 3, 9, 10, 12};
    int K = 7;
    Solution solution = new Solution();
    System.out.println(solution.solution(scoville, K));
  }
}
