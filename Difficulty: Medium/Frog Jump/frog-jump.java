//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of test cases
        String str = br.readLine();
        int t = Integer.parseInt(str.trim());

        // Process each test case
        while (t-- > 0) {
            // Read the next line containing the array elements
            str = br.readLine();
            String[] tokens = str.trim().split("\\s+");

            // Convert the input strings to integers and store in an array
            ArrayList<Integer> list = new ArrayList<>();
            for (String token : tokens) {
                if (!token.isEmpty()) { // Ensure that the token is not empty
                    list.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to int[] for processing
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            // Create an instance of Solution and compute the minimum energy
            Solution ob = new Solution();
            int result = ob.minCost(arr);

            // Output the result followed by a tilde as per the original C++ code
            System.out.println(result);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

// User function Template for Java
//import java.util.Arrays;
class Solution {
    int helper(int idx,int height[],int dp[])
    {
        if(idx==0)
        return 0;
        if(dp[idx]!=-1)
        return dp[idx];
        int left=helper(idx-1,height,dp)+Math.abs(height[idx]-height[idx-1]);
        int right=Integer.MAX_VALUE;
        if(idx>1)
        right=helper(idx-2,height,dp)+Math.abs(height[idx]-height[idx-2]);
        return dp[idx]=Math.min(left,right);
    }
    int minCost(int[] height) {
        // code here
        int dp[]=new int[height.length];
        for(int i=0;i<height.length;i++)
        {
            dp[i]=-1;
        }
        return helper(height.length-1,height,dp);
    }
}


//{ Driver Code Starts.

// } Driver Code Ends