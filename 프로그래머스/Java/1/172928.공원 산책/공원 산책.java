class Solution {
    public int[] solution(String[] park, String[] routes) {
        int row = 0;
        int col = 0;

        // 시작 위치 S 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    row = i;
                    col = j;
                }
            }
        }

        for (String route : routes) {
            String[] command = route.split(" ");

            char direction = command[0].charAt(0);
            int distance = Integer.parseInt(command[1]);

            int nextRow = row;
            int nextCol = col;
            boolean possible = true;

            for (int i = 0; i < distance; i++) {
                if (direction == 'N') {
                    nextRow--;
                } else if (direction == 'S') {
                    nextRow++;
                } else if (direction == 'W') {
                    nextCol--;
                } else if (direction == 'E') {
                    nextCol++;
                }

                // 공원 범위를 벗어나는지 확인
                if (nextRow < 0 || nextRow >= park.length
                        || nextCol < 0 || nextCol >= park[0].length()) {
                    possible = false;
                    break;
                }

                // 장애물이 있는지 확인
                if (park[nextRow].charAt(nextCol) == 'X') {
                    possible = false;
                    break;
                }
            }

            // 모든 경로가 이동 가능할 때만 실제 위치 변경
            if (possible) {
                row = nextRow;
                col = nextCol;
            }
        }

        return new int[]{row, col};
    }
}