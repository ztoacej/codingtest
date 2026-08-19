import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];

        Arrays.fill(dp, -1);
        dp[x] = 0;

        for (int i = x; i <= y; i++) {

            if (dp[i] == -1) {
                continue;
            }

            if (i + n <= y) {
                update(dp, i + n, dp[i] + 1);
            }

            if (i * 2 <= y) {
                update(dp, i * 2, dp[i] + 1);
            }

            if (i * 3 <= y) {
                update(dp, i * 3, dp[i] + 1);
            }
        }

        return dp[y];
    }

    private void update(int[] dp, int next, int count) {
        if (dp[next] == -1) {
            dp[next] = count;
        } else {
            dp[next] = Math.min(dp[next], count);
        }
    }
}