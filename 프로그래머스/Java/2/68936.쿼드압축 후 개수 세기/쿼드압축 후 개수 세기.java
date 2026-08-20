class Solution {

    private int[] answer = new int[2];

    public int[] solution(int[][] arr) {

        compress(arr, 0, 0, arr.length);

        return answer;
    }

    private void compress(int[][] arr, int row, int col, int size) {

        // 현재 영역이 모두 같은 숫자인지 확인
        if (isSame(arr, row, col, size)) {
            answer[arr[row][col]]++;
            return;
        }

        // 같지 않다면 4등분
        int half = size / 2;

        compress(arr, row, col, half);               // 왼쪽 위
        compress(arr, row, col + half, half);        // 오른쪽 위
        compress(arr, row + half, col, half);        // 왼쪽 아래
        compress(arr, row + half, col + half, half); // 오른쪽 아래
    }

    private boolean isSame(int[][] arr, int row, int col, int size) {

        int value = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {

                if (arr[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }
}