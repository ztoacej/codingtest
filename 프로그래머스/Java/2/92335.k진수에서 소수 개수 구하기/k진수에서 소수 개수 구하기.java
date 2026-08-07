class Solution {
    public int solution(int n, int k) {
        String converted = Integer.toString(n, k);
        String[] candidates = converted.split("0");

        int answer = 0;

        for (String candidate : candidates) {
            if (candidate.isEmpty()) {
                continue;
            }

            long number = Long.parseLong(candidate);

            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }

        for (long divisor = 2; divisor <= number / divisor; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }
}