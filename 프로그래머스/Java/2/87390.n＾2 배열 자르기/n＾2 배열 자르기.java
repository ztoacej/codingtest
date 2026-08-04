class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (long index = left; index <= right; index++) {
            int row = (int) (index / n);
            int col = (int) (index % n);

            answer[(int) (index - left)] = Math.max(row, col) + 1;
        }

        return answer;
    }
}