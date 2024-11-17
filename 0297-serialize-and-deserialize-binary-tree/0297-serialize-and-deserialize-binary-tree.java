/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
        return null;
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder res=new StringBuilder();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode cur=q.poll();
            if(cur==null)
            {
                res.append("n ");
                continue;
            }
            res.append(cur.val+" ");
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return res.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty())
        return null;
        Queue<TreeNode> q=new LinkedList<>();
        String values[]=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.add(root);int i=1;
        while(!q.isEmpty() && i<values.length)
        {
            TreeNode parent=q.poll();
            if(!values[i].equals("n"))
            {
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                q.add(left);
            }
            i++;
            if(i<values.length && !values[i].equals("n"))
            {
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                q.add(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));