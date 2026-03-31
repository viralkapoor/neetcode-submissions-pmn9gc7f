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

public class Codec {
    int id;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if(root==null) {
            sb.append("N,");
            return;
        }

        sb.append(String.valueOf(root.val) + ",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String st[] = data.split(",");
        id = 0;

        return derserialize(st);
    }

    public TreeNode derserialize(String []ch) {
        if(ch[id].equals("N")) {
            id++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(ch[id++]));
        root.left = derserialize(ch);
        root.right = derserialize(ch);
        return root;
    }
}
