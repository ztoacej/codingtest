class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isFirst = true;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == ' ') {
                answer.append(current);
                isFirst = true;
            } else {
                if (isFirst) {
                    answer.append(Character.toUpperCase(current));
                    isFirst = false;
                } else {
                    answer.append(Character.toLowerCase(current));
                }
            }
        }

        return answer.toString();
    }
}