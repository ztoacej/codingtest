import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rankMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        for (String calledPlayer : callings) {
            int currentIndex = rankMap.get(calledPlayer);
            int frontIndex = currentIndex - 1;

            String frontPlayer = players[frontIndex];

            players[frontIndex] = calledPlayer;
            players[currentIndex] = frontPlayer;

            rankMap.put(calledPlayer, frontIndex);
            rankMap.put(frontPlayer, currentIndex);
        }

        return players;
    }
}