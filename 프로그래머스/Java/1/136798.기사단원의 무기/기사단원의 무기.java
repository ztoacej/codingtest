class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int divisorCount = countDivisors(i);

            if (divisorCount > limit) {
                answer += power;
            } else {
                answer += divisorCount;
            }
        }

        return answer;
    }

    private int countDivisors(int number) {
        int count = 0;

        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                count += 2;

                if (i * i == number) {
                    count--;
                }
            }
        }

        return count;
    }
}