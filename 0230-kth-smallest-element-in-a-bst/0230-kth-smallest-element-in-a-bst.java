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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null)
        return -1;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int level=q.size();
            for(int i=0;i<level;i++)
            {
                TreeNode cur=q.poll();
                if(cur.left!=null)
                q.offer(cur.left);
                if(cur.right!=null)
                q.offer(cur.right);
                list.add(cur.val);
            }
        }
        Collections.sort(list);
        return list.get(k-1);
    }
}