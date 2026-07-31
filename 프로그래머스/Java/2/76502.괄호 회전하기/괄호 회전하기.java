import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);

            if (isCorrect(rotated)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();

                if ((c == ')' && open != '(')
                        || (c == '}' && open != '{')
                        || (c == ']' && open != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}