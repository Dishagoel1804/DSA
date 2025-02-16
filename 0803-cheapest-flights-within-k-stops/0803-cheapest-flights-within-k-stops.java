import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Adjacency list representation of graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        // Queue for BFS (city, cost, stops)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0}); // Start with source

        // Distance array to track min cost to reach each city within given stops
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int city = current[0], cost = current[1], stops = current[2];

            // If we exceed allowed stops, continue
            if (stops > k) continue;

            // Explore neighbors
            for (int[] neighbor : graph.getOrDefault(city, new ArrayList<>())) {
                int nextCity = neighbor[0], price = neighbor[1];

                // If we find a cheaper route within the allowed stops, update and enqueue
                if (cost + price < minCost[nextCity]) {
                    minCost[nextCity] = cost + price;
                    queue.offer(new int[]{nextCity, cost + price, stops + 1});
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
