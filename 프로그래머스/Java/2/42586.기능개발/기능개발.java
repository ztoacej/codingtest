import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deployments = new ArrayList<>();

        int currentDay = getRequiredDays(progresses[0], speeds[0]);
        int count = 1;

        for (int i = 1; i < progresses.length; i++) {
            int requiredDays = getRequiredDays(progresses[i], speeds[i]);

            if (requiredDays <= currentDay) {
                count++;
            } else {
                deployments.add(count);
                currentDay = requiredDays;
                count = 1;
            }
        }

        deployments.add(count);

        int[] answer = new int[deployments.size()];

        for (int i = 0; i < deployments.size(); i++) {
            answer[i] = deployments.get(i);
        }

        return answer;
    }

    private int getRequiredDays(int progress, int speed) {
        return (100 - progress + speed - 1) / speed;
    }
}