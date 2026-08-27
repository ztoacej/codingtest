import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {
                return Integer.compare(b[0], a[0]);
            }

            return Integer.compare(a[col - 1], b[col - 1]);
        });

        int answer = 0;

        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int rowNumber = i + 1;
            int sum = 0;

            for (int value : data[i]) {
                sum += value % rowNumber;
            }

            answer ^= sum;
        }

        return answer;
    }
}