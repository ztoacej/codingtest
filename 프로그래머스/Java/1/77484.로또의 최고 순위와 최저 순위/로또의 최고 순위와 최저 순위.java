class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] ranks = {6, 6, 5, 4, 3, 2, 1};

        int zeroCount = 0;
        int matchCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
            } else {
                for (int win : win_nums) {
                    if (lotto == win) {
                        matchCount++;
                        break;
                    }
                }
            }
        }

        return new int[]{
                ranks[matchCount + zeroCount],
                ranks[matchCount]
        };
    }
}