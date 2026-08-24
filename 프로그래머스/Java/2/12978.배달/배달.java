import java.util.*;

class Solution {

    static class Node implements Comparable<Node> {
        int village;
        int distance;

        Node(int village, int distance) {
            this.village = village;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

    public int solution(int N, int[][] road, int K) {
        List<Node>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 도로 저장
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int cost = r[2];

            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int currentVillage = current.village;
            int currentDistance = current.distance;

            // 이미 더 짧은 거리로 처리된 경우
            if (currentDistance > dist[currentVillage]) {
                continue;
            }

            for (Node next : graph[currentVillage]) {
                int newDistance = currentDistance + next.distance;

                if (newDistance < dist[next.village]) {
                    dist[next.village] = newDistance;
                    pq.offer(new Node(next.village, newDistance));
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}