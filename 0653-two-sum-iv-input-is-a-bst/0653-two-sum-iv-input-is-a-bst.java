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
     List<Integer> inorder(List<Integer> list,TreeNode root)
        {
            Stack<TreeNode> st=new Stack<>();
            list=new ArrayList<>();
            TreeNode cur=root;
       while(cur!=null || (!st.isEmpty()))
       {
        while(cur!=null)
        {
            st.push(cur);
            cur=cur.left;
        }
        cur=st.pop();
        list.add(cur.val);
        cur=cur.right;
       }
        return list;
        }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        list=inorder(list,root);
        int l=0,r=list.size()-1;
        int sum=0;
        while(l<r)
        {
            sum=list.get(l)+list.get(r);
            if(sum>k)
            r--;
            else if(sum<k)
            l++;
            else
            return true;
        }
        return false;
    }
}