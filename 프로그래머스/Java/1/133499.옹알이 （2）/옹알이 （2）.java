class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] sounds = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            boolean repeated = false;

            for (String sound : sounds) {
                if (word.contains(sound + sound)) {
                    repeated = true;
                    break;
                }
            }

            if (repeated) {
                continue;
            }

            for (String sound : sounds) {
                word = word.replace(sound, " ");
            }

            if (word.trim().isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}