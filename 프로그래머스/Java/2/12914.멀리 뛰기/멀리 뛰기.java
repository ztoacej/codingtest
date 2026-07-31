class Solution {
    public long solution(int n) {
        long previous = 1;
        long current = 1;

        for (int i = 2; i <= n; i++) {
            long next = (previous + current) % 1234567;

            previous = current;
            current = next;
        }

        return current;
    }
}