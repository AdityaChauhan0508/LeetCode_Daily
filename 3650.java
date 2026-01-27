import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {
        // Building augmented graph
        ArrayList<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) 
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, 2 * w});
        }

        // Initialize distance array from 0 node
        final int INF = 1000000000;
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) 
            dist[i] = INF;
        dist[0] = 0;

        // Dijkstra
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (u == n - 1)  // Early exit
                return d;
            if (d != dist[u])  // Stale edge
                continue;

            for (int i = 0; i < adj[u].size(); i++) {
                int[] e = adj[u].get(i);
                int v = e[0], w = e[1];
                if (dist[u] + w < dist[v]) {  // Edge relaxation
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        return -1;
    }
}