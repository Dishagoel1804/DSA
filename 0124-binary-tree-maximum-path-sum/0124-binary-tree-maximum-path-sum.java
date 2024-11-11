/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxsum=Integer.MIN_VALUE;
    int sum;
    public int Sum(TreeNode root)
    {
        if(root==null)
        return 0;
        int leftsum=Math.max(Sum(root.left),0);
        int rightsum=Math.max(Sum(root.right),0);
        sum=root.val+leftsum+rightsum;
        maxsum=Math.max(maxsum,sum);
        return root.val+(Math.max(leftsum,rightsum));
    }
    public int maxPathSum(TreeNode root) {
        Sum(root);
        return maxsum;
    }
}