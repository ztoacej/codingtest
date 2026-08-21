import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    private int rows;
    private int cols;
    private boolean[][] visited;

    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();

        visited = new boolean[rows][cols];

        List<Integer> islands = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (maps[r].charAt(c) != 'X' && !visited[r][c]) {
                    int sum = dfs(maps, r, c);
                    islands.add(sum);
                }
            }
        }

        if (islands.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(islands);

        int[] answer = new int[islands.size()];

        for (int i = 0; i < islands.size(); i++) {
            answer[i] = islands.get(i);
        }

        return answer;
    }

    private int dfs(String[] maps, int r, int c) {
        visited[r][c] = true;

        int sum = maps[r].charAt(c) - '0';

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

            sum += dfs(maps, nr, nc);
        }

        return sum;
    }
}