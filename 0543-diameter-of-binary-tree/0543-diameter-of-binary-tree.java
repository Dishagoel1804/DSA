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
    int maxheight=0;
    public int height(TreeNode root)
    {
        if(root==null)
        return 0;
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        maxheight=Math.max(maxheight,leftheight+rightheight);
        return 1+(Math.max(leftheight,rightheight));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxheight;
    }
}