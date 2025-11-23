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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
        return list;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int levelsize=q.size();
        List<Integer> currentlevel=new ArrayList<>();
        for(int i=0;i<levelsize;i++){
        TreeNode cur=q.poll();
        currentlevel.add(cur.val);
        if(cur.left!=null)
        q.add(cur.left);
        if(cur.right!=null)
        q.add(cur.right);
       } 
       list.add(currentlevel);
        }
        List<List<Integer>> list2=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--)
        {
            list2.add(list.get(i));
        }
        return list2;
    }
}