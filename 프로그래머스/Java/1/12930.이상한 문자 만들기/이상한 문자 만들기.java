class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                answer.append(' ');
                index = 0;
            } else {
                if (index % 2 == 0) {
                    answer.append(Character.toUpperCase(ch));
                } else {
                    answer.append(Character.toLowerCase(ch));
                }
                index++;
            }
        }

        return answer.toString();
    }
}