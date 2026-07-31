import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // 귤 크기별 개수 계산
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        // 크기별 개수만 리스트에 저장
        List<Integer> counts = new ArrayList<>(countMap.values());

        // 개수가 많은 순서대로 정렬
        counts.sort((a, b) -> b - a);

        int selectedCount = 0;
        int typeCount = 0;

        for (int count : counts) {
            selectedCount += count;
            typeCount++;

            if (selectedCount >= k) {
                break;
            }
        }

        return typeCount;
    }
}