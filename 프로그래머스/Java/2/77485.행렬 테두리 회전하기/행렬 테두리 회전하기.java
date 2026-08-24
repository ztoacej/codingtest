class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];

        int number = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                board[r][c] = number++;
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(board, queries[i]);
        }

        return answer;
    }

    private int rotate(int[][] board, int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int saved = board[x1][y1];
        int min = saved;

        // 왼쪽 변: 아래 → 위
        for (int r = x1; r < x2; r++) {
            board[r][y1] = board[r + 1][y1];
            min = Math.min(min, board[r][y1]);
        }

        // 아래쪽 변: 오른쪽 → 왼쪽
        for (int c = y1; c < y2; c++) {
            board[x2][c] = board[x2][c + 1];
            min = Math.min(min, board[x2][c]);
        }

        // 오른쪽 변: 위 → 아래
        for (int r = x2; r > x1; r--) {
            board[r][y2] = board[r - 1][y2];
            min = Math.min(min, board[r][y2]);
        }

        // 위쪽 변: 왼쪽 → 오른쪽
        for (int c = y2; c > y1 + 1; c--) {
            board[x1][c] = board[x1][c - 1];
            min = Math.min(min, board[x1][c]);
        }

        board[x1][y1 + 1] = saved;
        min = Math.min(min, saved);

        return min;
    }
}