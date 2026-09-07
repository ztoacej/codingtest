import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int[] start = findPosition(maps, 'S');
        int[] lever = findPosition(maps, 'L');
        int[] exit = findPosition(maps, 'E');

        // 시작점 → 레버
        int toLever = bfs(maps, start, lever);

        if (toLever == -1) {
            return -1;
        }

        // 레버 → 출구
        int toExit = bfs(maps, lever, exit);

        if (toExit == -1) {
            return -1;
        }

        return toLever + toExit;
    }

    private int bfs(String[] maps, int[] start, int[] target) {
        int rows = maps.length;
        int cols = maps[0].length();

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int distance = current[2];

            if (r == target[0] && c == target[1]) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                if (maps[nr].charAt(nc) == 'X') {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc, distance + 1});
            }
        }

        return -1;
    }

    private int[] findPosition(String[] maps, char target) {
        for (int r = 0; r < maps.length; r++) {
            for (int c = 0; c < maps[r].length(); c++) {
                if (maps[r].charAt(c) == target) {
                    return new int[]{r, c};
                }
            }
        }

        return null;
    }
}