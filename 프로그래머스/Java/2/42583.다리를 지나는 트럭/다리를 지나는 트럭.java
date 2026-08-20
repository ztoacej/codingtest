import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();

        int time = 0;
        int currentWeight = 0;
        int index = 0;

        // 처음에는 다리가 비어 있음
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (index < truck_weights.length) {
            time++;

            // 다리에서 한 칸 이동 → 맨 앞 트럭이 빠져나감
            currentWeight -= bridge.poll();

            // 다음 트럭이 올라갈 수 있는지 확인
            if (currentWeight + truck_weights[index] <= weight) {
                bridge.offer(truck_weights[index]);
                currentWeight += truck_weights[index];
                index++;
            } else {
                bridge.offer(0);
            }
        }

        // 마지막 트럭이 다리를 완전히 빠져나가는 시간
        return time + bridge_length;
    }
}