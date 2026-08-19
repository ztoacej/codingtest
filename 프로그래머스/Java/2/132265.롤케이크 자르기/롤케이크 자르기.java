import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }

        int answer = 0;

        for (int i = 0; i < topping.length - 1; i++) {
            int current = topping[i];

            // 왼쪽으로 이동
            left.add(current);

            // 오른쪽에서 제거
            right.put(current, right.get(current) - 1);

            if (right.get(current) == 0) {
                right.remove(current);
            }

            // 토핑 종류 수 비교
            if (left.size() == right.size()) {
                answer++;
            }
        }

        return answer;
    }
}