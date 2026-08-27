class Solution {
    public long solution(int w, int h) {
        long total = (long) w * h;

        long gcd = gcd(w, h);

        long broken = w + h - gcd;

        return total - broken;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}