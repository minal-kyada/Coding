// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

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
        if(root == null)
            return "X,";
        String lt = serialize(root.left);
        String rt = serialize(root.right);
        return root.val + "," + lt + rt;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return deSerializeHelper(q);
    }

    private TreeNode deSerializeHelper(Queue<String> q) {
        String val = q.poll();
        if (val.equals("X"))
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deSerializeHelper(q);
        node.right = deSerializeHelper(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));