import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
        }

        int order = 0;

        while (!queue.isEmpty()) {
            Process current = queue.poll();

            boolean hasHigherPriority = false;

            for (Process process : queue) {
                if (process.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                queue.offer(current);
            } else {
                order++;

                if (current.index == location) {
                    return order;
                }
            }
        }

        return -1;
    }

    private static class Process {
        int index;
        int priority;

        Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}