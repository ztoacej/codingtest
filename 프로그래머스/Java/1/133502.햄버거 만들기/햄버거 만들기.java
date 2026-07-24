class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int size = 0;
        int answer = 0;

        for (int food : ingredient) {
            stack[size++] = food;

            if (size >= 4
                    && stack[size - 4] == 1
                    && stack[size - 3] == 2
                    && stack[size - 2] == 3
                    && stack[size - 1] == 1) {

                size -= 4;
                answer++;
            }
        }

        return answer;
    }
}