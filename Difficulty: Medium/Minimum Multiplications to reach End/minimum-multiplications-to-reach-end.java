//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java
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
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start==end)
        return 0;
        int mod=100000;
        Queue<Pair> q=new LinkedList<>();
        int dist[]=new int[100000];
        q.add(new Pair(0,start));
        for(int i=0;i<dist.length;i++)
        dist[i]=Integer.MAX_VALUE;
        dist[start]=0;
        // Your code here
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int steps=p.first;
            int pro=p.second;
            for(int i=0;i<arr.length;i++)
            {
                int newpro=(pro*arr[i])%mod;
                if(dist[newpro]>steps+1)
                {
                    dist[newpro]=steps+1;
                    q.add(new Pair(steps+1,newpro));
                    if(newpro==end)
                    return steps+1;
                }
            }
        }
        return -1;
    }
}
