class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int different = 0;
        char first = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == first) {
                same++;
            } else {
                different++;
            }

            if (same == different) {
                answer++;

                same = 0;
                different = 0;

                if (i + 1 < s.length()) {
                    first = s.charAt(i + 1);
                }
            }
        }

        if (same != 0 || different != 0) {
            answer++;
        }

        return answer;
    }
}