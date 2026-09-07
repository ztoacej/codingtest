import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groups = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {

            if (visited[i]) {
                continue;
            }

            int count = 0;
            int current = i;

            while (!visited[current]) {
                visited[current] = true;
                count++;

                current = cards[current] - 1;
            }

            groups.add(count);
        }

        if (groups.size() < 2) {
            return 0;
        }

        groups.sort(Collections.reverseOrder());

        return groups.get(0) * groups.get(1);
    }
}