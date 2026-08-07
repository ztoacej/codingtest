import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");

            int time = toMinutes(parts[0]);
            String carNumber = parts[1];
            String status = parts[2];

            if (status.equals("IN")) {
                inTimeMap.put(carNumber, time);
            } else {
                int inTime = inTimeMap.remove(carNumber);
                int parkingTime = time - inTime;

                totalTimeMap.put(
                        carNumber,
                        totalTimeMap.getOrDefault(carNumber, 0) + parkingTime
                );
            }
        }

        // 출차하지 않은 차량은 23:59에 출차한 것으로 처리
        int endOfDay = toMinutes("23:59");

        for (Map.Entry<String, Integer> entry : inTimeMap.entrySet()) {
            String carNumber = entry.getKey();
            int inTime = entry.getValue();
            int parkingTime = endOfDay - inTime;

            totalTimeMap.put(
                    carNumber,
                    totalTimeMap.getOrDefault(carNumber, 0) + parkingTime
            );
        }

        // 차량 번호 오름차순 정렬
        List<String> carNumbers = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carNumbers);

        int[] answer = new int[carNumbers.size()];

        for (int i = 0; i < carNumbers.size(); i++) {
            int totalTime = totalTimeMap.get(carNumbers.get(i));
            answer[i] = calculateFee(totalTime, fees);
        }

        return answer;
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return hour * 60 + minute;
    }

    private int calculateFee(int totalTime, int[] fees) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalTime <= basicTime) {
            return basicFee;
        }

        int extraTime = totalTime - basicTime;
        int unitCount = (extraTime + unitTime - 1) / unitTime;

        return basicFee + unitCount * unitFee;
    }
}