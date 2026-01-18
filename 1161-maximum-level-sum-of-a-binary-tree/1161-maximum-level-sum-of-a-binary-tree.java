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
    public int maxLevelSum(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
       if(root==null)
       return 0;
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
       int max=Integer.MIN_VALUE;int a=0;
       for(int i=0;i<list.size();i++)
       {
        int sum=0;
        for(int j=0;j<list.get(i).size();j++)
        {
            sum+=(list.get(i)).get(j);
        }
        if(max<sum)
        {
            max=sum;
            a=i;
        }
       }
       return a+1;
    }
}