import java.util.*;

class Pair {
    long first;
    int second;
    Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int src = 0, dest = n - 1;
        
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Build graph
        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[2], road[1])); // Pair(weight, destination)
            adj.get(road[1]).add(new Pair(road[2], road[0]));
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[src] = 0;
        ways[src] = 1;
        int mod = 1_000_000_007;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.first));
        pq.add(new Pair(0L, src));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            long time = p.first;
            int node = p.second;

            if (time > dist[node]) continue;

            for (Pair iter : adj.get(node)) {
                long t = iter.first;
                int d = iter.second;

                if (time + t < dist[d]) {
                    dist[d] = time + t;
                    ways[d] = ways[node];
                    pq.add(new Pair(dist[d], d));
                } else if (time + t == dist[d]) {
                    ways[d] = (ways[d] + ways[node]) % mod;
                }
            }
        }
        
        return (int) (ways[dest] % mod);
    }
}
