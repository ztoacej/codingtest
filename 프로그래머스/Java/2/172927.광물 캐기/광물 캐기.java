import java.util.ArrayList;
import java.util.List;

class Solution {

    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];

        // 실제로 캘 수 있는 광물 개수
        int maxMinerals = Math.min(minerals.length, totalPicks * 5);

        List<int[]> groups = new ArrayList<>();

        // 광물을 5개씩 그룹화
        for (int i = 0; i < maxMinerals; i += 5) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < Math.min(i + 5, maxMinerals); j++) {
                if (minerals[j].equals("diamond")) {
                    diamond++;
                } else if (minerals[j].equals("iron")) {
                    iron++;
                } else {
                    stone++;
                }
            }

            groups.add(new int[]{diamond, iron, stone});
        }

        // 어려운 그룹부터 정렬
        groups.sort((a, b) -> {
            int fatigueA = a[0] * 25 + a[1] * 5 + a[2];
            int fatigueB = b[0] * 25 + b[1] * 5 + b[2];

            return fatigueB - fatigueA;
        });

        int answer = 0;

        for (int[] group : groups) {

            // 다이아 곡괭이
            if (picks[0] > 0) {
                answer += group[0] + group[1] + group[2];
                picks[0]--;
            }

            // 철 곡괭이
            else if (picks[1] > 0) {
                answer += group[0] * 5
                        + group[1]
                        + group[2];
                picks[1]--;
            }

            // 돌 곡괭이
            else if (picks[2] > 0) {
                answer += group[0] * 25
                        + group[1] * 5
                        + group[2];
                picks[2]--;
            }
        }

        return answer;
    }
}