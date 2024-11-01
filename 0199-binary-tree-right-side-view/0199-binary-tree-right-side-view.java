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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
        return list;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int levelsize=q.size();
            TreeNode rightmost=null;
            for(int i=0;i<levelsize;i++)
            {
                TreeNode cur=q.poll();
                rightmost=cur;
                if(cur.left!=null)
                q.offer(cur.left);
                if(cur.right!=null)
                q.offer(cur.right);
            }
            list.add(rightmost.val);
        }
        return list;
    }
}