import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {

            // 일단 병사를 사용해서 막는다.
            n -= enemy[i];

            // 지금까지 등장한 적의 수를 저장
            pq.offer(enemy[i]);

            // 병사가 부족해졌다면
            if (n < 0) {

                // 무적권을 사용할 수 없는 경우
                if (k == 0) {
                    return i;
                }

                // 지금까지 가장 큰 라운드에 무적권 사용
                n += pq.poll();
                k--;
            }
        }

        return enemy.length;
    }
}