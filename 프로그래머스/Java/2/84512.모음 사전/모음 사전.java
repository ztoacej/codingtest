class Solution {

    private int count = 0;
    private int answer = 0;

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    private void dfs(String current, String word) {

        if (current.length() > 5) {
            return;
        }

        if (!current.isEmpty()) {
            count++;

            if (current.equals(word)) {
                answer = count;
                return;
            }
        }

        String vowels = "AEIOU";

        for (int i = 0; i < 5; i++) {
            dfs(current + vowels.charAt(i), word);
        }
    }
}