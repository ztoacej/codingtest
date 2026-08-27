import java.util.*;

class Solution {

    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = checkRoom(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean checkRoom(String[] room) {

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {

                if (room[r].charAt(c) == 'P') {
                    if (!bfs(room, r, c)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean bfs(String[] room, int startR, int startC) {

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        queue.offer(new int[]{startR, startC, 0});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int distance = current[2];

            if (distance >= 2) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                // 파티션은 통과할 수 없음
                if (room[nr].charAt(nc) == 'X') {
                    continue;
                }

                // 거리 2 이내에서 다른 응시자를 발견
                if (room[nr].charAt(nc) == 'P') {
                    return false;
                }

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc, distance + 1});
            }
        }

        return true;
    }
}