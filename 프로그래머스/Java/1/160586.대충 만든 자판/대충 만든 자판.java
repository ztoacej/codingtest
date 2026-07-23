import java.util.Arrays;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] minPress = new int[26];
        Arrays.fill(minPress, Integer.MAX_VALUE);

        // 문자별 최소 입력 횟수 저장
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                int alphabetIndex = key.charAt(i) - 'A';
                int pressCount = i + 1;

                minPress[alphabetIndex]
                        = Math.min(minPress[alphabetIndex], pressCount);
            }
        }

        int[] answer = new int[targets.length];

        // 각 target을 입력하는 데 필요한 횟수 계산
        for (int i = 0; i < targets.length; i++) {
            int total = 0;

            for (int j = 0; j < targets[i].length(); j++) {
                int alphabetIndex = targets[i].charAt(j) - 'A';

                if (minPress[alphabetIndex] == Integer.MAX_VALUE) {
                    total = -1;
                    break;
                }

                total += minPress[alphabetIndex];
            }

            answer[i] = total;
        }

        return answer;
    }
}