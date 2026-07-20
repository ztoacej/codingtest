class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int received = (n / a) * b;

            answer += received;
            n = (n % a) + received;
        }

        return answer;
    }
}