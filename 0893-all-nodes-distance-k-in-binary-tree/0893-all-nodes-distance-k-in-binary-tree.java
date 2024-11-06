/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void matchParent(TreeNode root,Map<TreeNode,TreeNode> parentMap)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode cur=q.poll();
            if(cur.left!=null)
            {
                q.offer(cur.left);
                parentMap.put(cur.left,cur);
            }
            if(cur.right!=null)
            {
                q.offer(cur.right);
                parentMap.put(cur.right,cur);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap=new HashMap<>();
        matchParent(root,parentMap);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        Set<TreeNode> set=new HashSet<>();
        set.add(target);
        int cd=0;
        while(!q.isEmpty())
        {
            if(cd==k)
            {
                List<Integer> list=new ArrayList<>();
            while(!q.isEmpty())
            list.add(q.poll().val);
            return list;
            }
            cd++;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode cur=q.poll();
                if(cur.left!=null && !set.contains(cur.left))
                {
                    set.add(cur.left);
                    q.offer(cur.left);
                }
                if(cur.right!=null && !set.contains(cur.right))
                {
                    set.add(cur.right);
                    q.offer(cur.right);
                }
                if(parentMap.containsKey(cur) && !set.contains(parentMap.get(cur)))
                {
                    set.add(parentMap.get(cur));
                    q.offer(parentMap.get(cur));
                }
            } 
        }
         return new ArrayList<>();
    }
}