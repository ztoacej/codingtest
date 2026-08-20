import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();

        int box = 1;
        int index = 0;

        while (box <= order.length) {

            // 지금 원하는 상자라면 바로 싣기
            if (box == order[index]) {
                index++;
                box++;
            } else {
                // 아니면 보조 벨트에 넣기
                stack.push(box);
                box++;
            }

            // 보조 벨트 맨 위에 원하는 상자가 있으면 계속 꺼내기
            while (!stack.isEmpty()
                    && index < order.length
                    && stack.peek() == order[index]) {

                stack.pop();
                index++;
            }
        }

        return index;
    }
}