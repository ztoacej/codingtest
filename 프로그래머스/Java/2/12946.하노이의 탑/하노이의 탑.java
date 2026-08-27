import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<int[]> moves = new ArrayList<>();

    public int[][] solution(int n) {

        hanoi(n, 1, 3, 2);

        int[][] answer = new int[moves.size()][2];

        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }

        return answer;
    }

    private void hanoi(int n, int from, int to, int via) {

        if (n == 1) {
            moves.add(new int[]{from, to});
            return;
        }

        // 1. 위의 n-1개를 보조 기둥으로 이동
        hanoi(n - 1, from, via, to);

        // 2. 가장 큰 원판을 목적지로 이동
        moves.add(new int[]{from, to});

        // 3. 보조 기둥의 n-1개를 목적지로 이동
        hanoi(n - 1, via, to, from);
    }
}