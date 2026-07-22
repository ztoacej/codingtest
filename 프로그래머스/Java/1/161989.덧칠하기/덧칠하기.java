class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int painted = 0;

        for (int wall : section) {
            if (wall > painted) {
                answer++;
                painted = wall + m - 1;
            }
        }

        return answer;
    }
}