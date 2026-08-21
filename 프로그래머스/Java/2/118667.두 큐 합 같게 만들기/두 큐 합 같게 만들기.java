class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;

        long sum1 = 0;
        long sum2 = 0;

        for (int value : queue1) {
            sum1 += value;
        }

        for (int value : queue2) {
            sum2 += value;
        }

        long total = sum1 + sum2;

        if (total % 2 != 0) {
            return -1;
        }

        long target = total / 2;

        int[] combined = new int[n * 2];

        for (int i = 0; i < n; i++) {
            combined[i] = queue1[i];
            combined[i + n] = queue2[i];
        }

        int left = 0;
        int right = n;
        int count = 0;

        while (count <= n * 3) {
            if (sum1 == target) {
                return count;
            }

            if (sum1 < target) {
                sum1 += combined[right % (2 * n)];
                right++;
            } else {
                sum1 -= combined[left % (2 * n)];
                left++;
            }

            count++;
        }

        return -1;
    }
}