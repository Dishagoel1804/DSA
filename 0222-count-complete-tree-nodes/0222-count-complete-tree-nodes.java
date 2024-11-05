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
    public int countNodes(TreeNode root) {
        int c=0;
        if(root==null)
        return c;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int levelsize=q.size();
            for(int i=0;i<levelsize;i++)
            {
                TreeNode cur=q.poll();
                c++;
                if(cur.left!=null)
                q.offer(cur.left);
                if(cur.right!=null)
                q.offer(cur.right);
            }
        }
        return c;
    }
}