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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inmap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        inmap.put(inorder[i],i);
        TreeNode root=helpbuildtree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,inmap);
        return root;
    }
    TreeNode helpbuildtree(int[] inorder,int instart,int inend,int[] postorder,int poststart,int postend,Map<Integer,Integer> inmap)
    {
        if(poststart>postend || instart>inend)
        return null;
        TreeNode root=new TreeNode(postorder[postend]);
        int inroot=inmap.get(root.val);
        int numsleft=inroot-instart;
        root.left=helpbuildtree(inorder,instart,inroot-1,postorder,poststart,poststart+numsleft-1,inmap);
        root.right=helpbuildtree(inorder,inroot+1,inend,postorder,poststart+numsleft,postend-1,inmap);
        return root;
    }
}