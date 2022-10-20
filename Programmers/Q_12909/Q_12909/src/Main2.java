import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    boolean solution(String s) {
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                queue.add("(");
            } else {
                if (queue.isEmpty()) {
                    return false;
                } else {
                    queue.remove();
                }
            }
        }
        if (queue.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}

public class Main2 {
    public static void main(String[] args) {

        Solution2 solution = new Solution2();

        System.out.println(solution.solution("()()"));
    }
}