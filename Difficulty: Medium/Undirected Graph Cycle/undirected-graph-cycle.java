//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Pair
{
    int first,second;
    Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean checkiscycle(int src,int v,ArrayList<ArrayList<Integer>> adj,boolean vis[])
    {
        vis[src]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,-1));
        while(!q.isEmpty())
        {
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int i:adj.get(node))
            {
                if(vis[i]==false)
                {
                    vis[i]=true;
                    q.add(new Pair(i,node));
                }
                else if(parent!=i)
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int v=adj.size();
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++)
        vis[i]=false;
        for(int i=0;i<v;i++)
        {
            if(vis[i]==false)
            {
                if(checkiscycle(i,v,adj,vis))
                return true;
            }
        }
        return false;
    }
}