class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];

        int row = -1;
        int col = 0;
        int number = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (i % 3 == 0) {
                    row++;
                } else if (i % 3 == 1) {
                    col++;
                } else {
                    row--;
                    col--;
                }

                triangle[row][col] = number++;
            }
        }

        int[] answer = new int[n * (n + 1) / 2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}