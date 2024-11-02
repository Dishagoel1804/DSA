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
    public int widthOfBinaryTree(TreeNode root) {
       if(root==null)
       return 0;
       int max=0;
       Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
       q.offer(new Pair<>(root,0));
       while(!q.isEmpty())
       {
        int size=q.size();
        int first=0,last=0;
        for(int i=0;i<size;i++)
        {
            Pair<TreeNode,Integer> current=q.poll();
            TreeNode cur=current.getKey();
            int index=current.getValue();
            if(i==0)
            first=index;
            if(i==size-1)
            last=index;
            if(cur.left!=null)
            q.offer(new Pair<>(cur.left,2*index));
            if(cur.right!=null)
            q.offer(new Pair<>(cur.right,2*index+1));
        }
        max=Math.max(max,last-first+1);
       }
       return max;
    }
}