import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push("(");
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution("()()"));
    }
}