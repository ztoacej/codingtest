import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> clothesMap = new HashMap<>();

        // 의상 종류별 개수 저장
        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        int answer = 1;

        // (개수 + 1)을 모두 곱하기
        for (int count : clothesMap.values()) {
            answer *= (count + 1);
        }

        // 아무것도 안 입는 경우 제외
        return answer - 1;
    }
}