class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int current = storey % 10;
            int next = (storey / 10) % 10;

            if (current > 5) {
                answer += 10 - current;
                storey += 10;
            } else if (current < 5) {
                answer += current;
            } else {
                // current == 5
                if (next >= 5) {
                    answer += 5;
                    storey += 10;
                } else {
                    answer += 5;
                }
            }

            storey /= 10;
        }

        return answer;
    }
}