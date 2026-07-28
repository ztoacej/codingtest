import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> indexMap = new HashMap<>();
        Map<String, Integer> reportedCount = new HashMap<>();
        Set<String> uniqueReports = new HashSet<>();

        // 사용자별 배열 인덱스 저장
        for (int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
        }

        // 중복 신고 제거
        for (String reportInfo : report) {
            uniqueReports.add(reportInfo);
        }

        // 각 사용자가 신고당한 횟수 계산
        for (String reportInfo : uniqueReports) {
            String[] parts = reportInfo.split(" ");
            String reportedUser = parts[1];

            reportedCount.put(
                    reportedUser,
                    reportedCount.getOrDefault(reportedUser, 0) + 1
            );
        }

        int[] answer = new int[id_list.length];

        // 정지된 사용자를 신고한 사람에게 메일 횟수 추가
        for (String reportInfo : uniqueReports) {
            String[] parts = reportInfo.split(" ");

            String reporter = parts[0];
            String reportedUser = parts[1];

            if (reportedCount.getOrDefault(reportedUser, 0) >= k) {
                answer[indexMap.get(reporter)]++;
            }
        }

        return answer;
    }
}