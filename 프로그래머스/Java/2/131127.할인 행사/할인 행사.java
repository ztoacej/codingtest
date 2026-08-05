import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();

        // 원하는 상품 저장
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 첫 10일 할인 상품 저장
        for (int i = 0; i < 10; i++) {
            discountMap.put(
                    discount[i],
                    discountMap.getOrDefault(discount[i], 0) + 1
            );
        }

        int answer = 0;

        if (wantMap.equals(discountMap)) {
            answer++;
        }

        // 윈도우 이동
        for (int i = 10; i < discount.length; i++) {

            // 빠지는 상품
            String remove = discount[i - 10];

            if (discountMap.get(remove) == 1) {
                discountMap.remove(remove);
            } else {
                discountMap.put(remove, discountMap.get(remove) - 1);
            }

            // 새로 들어오는 상품
            String add = discount[i];

            discountMap.put(
                    add,
                    discountMap.getOrDefault(add, 0) + 1
            );

            if (wantMap.equals(discountMap)) {
                answer++;
            }
        }

        return answer;
    }
}