import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        int n = elements.length;

        for (int start = 0; start < n; start++) {
            int sum = 0;

            for (int length = 1; length <= n; length++) {
                int index = (start + length - 1) % n;

                sum += elements[index];
                sums.add(sum);
            }
        }

        return sums.size();
    }
}