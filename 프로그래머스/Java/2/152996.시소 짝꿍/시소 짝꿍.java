import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);

        Map<Integer, Integer> countMap = new HashMap<>();
        long answer = 0;

        for (int weight : weights) {

            // 같은 몸무게
            answer += countMap.getOrDefault(weight, 0);

            // 2 : 3
            if (weight * 2 % 3 == 0) {
                answer += countMap.getOrDefault(weight * 2 / 3, 0);
            }

            // 1 : 2 (= 2 : 4)
            if (weight % 2 == 0) {
                answer += countMap.getOrDefault(weight / 2, 0);
            }

            // 3 : 4
            if (weight * 3 % 4 == 0) {
                answer += countMap.getOrDefault(weight * 3 / 4, 0);
            }

            countMap.put(
                    weight,
                    countMap.getOrDefault(weight, 0) + 1
            );
        }

        return answer;
    }
}