import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = toMinutes(book_time[i][0]);
            times[i][1] = toMinutes(book_time[i][1]) + 10;
        }

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int[] time : times) {
            int start = time[0];
            int end = time[1];

            if (!rooms.isEmpty() && rooms.peek() <= start) {
                rooms.poll();
            }

            rooms.offer(end);
        }

        return rooms.size();
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        return hour * 60 + minute;
    }
}