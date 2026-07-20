import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> hallOfFame = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            hallOfFame.offer(score[i]);

            if (hallOfFame.size() > k) {
                hallOfFame.poll();
            }

            answer[i] = hallOfFame.peek();
        }

        return answer;
    }
}