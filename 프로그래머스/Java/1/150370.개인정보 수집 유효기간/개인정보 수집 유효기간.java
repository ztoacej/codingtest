import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();

        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }

        int todayDays = convertToDays(today);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");

            String collectedDate = parts[0];
            String termType = parts[1];

            int collectedDays = convertToDays(collectedDate);
            int expirationDays =
                    collectedDays + termMap.get(termType) * 28;

            if (expirationDays <= todayDays) {
                result.add(i + 1);
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private int convertToDays(String date) {
        String[] parts = date.split("\\.");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return year * 12 * 28 + month * 28 + day;
    }
}