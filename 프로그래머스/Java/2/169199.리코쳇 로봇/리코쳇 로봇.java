import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();

        int startR = 0;
        int startC = 0;

        // 시작 위치 R 찾기
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r].charAt(c) == 'R') {
                    startR = r;
                    startC = c;
                }
            }
        }

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startR, startC, 0});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int count = current[2];

            // 목표 지점 도착
            if (board[r].charAt(c) == 'G') {
                return count;
            }

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {

                int nr = r;
                int nc = c;

                // 장애물 또는 보드 끝을 만날 때까지 이동
                while (true) {
                    int nextR = nr + dr[i];
                    int nextC = nc + dc[i];

                    // 보드 밖이면 현재 위치에서 멈춤
                    if (nextR < 0 || nextR >= rows
                            || nextC < 0 || nextC >= cols) {
                        break;
                    }

                    // 장애물이면 현재 위치에서 멈춤
                    if (board[nextR].charAt(nextC) == 'D') {
                        break;
                    }

                    nr = nextR;
                    nc = nextC;
                }

                // 처음 방문하는 정지 지점만 BFS에 추가
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, count + 1});
                }
            }
        }

        return -1;
    }
}