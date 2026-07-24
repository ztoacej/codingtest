class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int moveCount = 0;

            while (moveCount < index) {
                current++;

                if (current > 'z') {
                    current = 'a';
                }

                if (skip.indexOf(current) == -1) {
                    moveCount++;
                }
            }

            answer.append(current);
        }

        return answer.toString();
    }
}