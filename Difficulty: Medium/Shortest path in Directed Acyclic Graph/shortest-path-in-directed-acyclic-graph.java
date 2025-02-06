//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

//import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Topological Sorting using DFS
    void topoSort(ArrayList<ArrayList<Pair>> adj, int vis[], int node, Stack<Integer> st) {
        vis[node] = 1;
        for (Pair neighbor : adj.get(node)) { // Correctly accessing Pair object
            int v = neighbor.first;
            if (vis[v] == 0) {
                topoSort(adj, vis, v, st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Step 1: Build the adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Step 2: Perform Topological Sorting ONLY from source node (0)
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        topoSort(adj, vis, 0, st);  // Start only from node 0

        // Step 3: Initialize Distance Array
        int dis[] = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;  // Distance to the source is 0

        // Step 4: Relaxation of Nodes in Topological Order
        while (!st.isEmpty()) {
            int node = st.pop();
            if (dis[node] != Integer.MAX_VALUE) {  // Process only reachable nodes
                for (Pair p : adj.get(node)) {
                    int v = p.first;
                    int wt = p.second;
                    if (dis[node] + wt < dis[v]) {
                        dis[v] = dis[node] + wt;
                    }
                }
            }
        }

        // Step 5: Convert Unreachable Distances to -1
        for (int i = 0; i < V; i++) {
            if (dis[i] == Integer.MAX_VALUE)
                dis[i] = -1;
        }
        return dis;
    }
}
