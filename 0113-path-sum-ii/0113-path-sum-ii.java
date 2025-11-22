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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        helper(root,0,targetSum,list,new ArrayList<>());
        return list;
    }
    void helper(TreeNode node,int sum,int target,List<List<Integer>> list,List<Integer> list1)
    {
        if(node==null)
        return;
        sum+=node.val;
        list1.add(node.val);
        if(node.left==null && node.right==null && sum==target)
        list.add(new ArrayList<>(list1));
        helper(node.left,sum,target,list,list1);
        helper(node.right,sum,target,list,list1);
        list1.remove(list1.size()-1);
    }
}