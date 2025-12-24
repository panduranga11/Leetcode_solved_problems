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
    public TreeNode buildTree(int[] pre, int[] in) {
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            pos.put(in[i], i);
        }
        return build(pre, pos, 0, in.length - 1, 0, pre.length - 1);

    }

    public TreeNode build(int[] pre, HashMap<Integer, Integer> pos, int is, int ie, int ps, int pe) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = pre[ps];
        int ipos = pos.get(root.val);
        int numleft = ipos - is;
        root.left = build(pre, pos, is, ipos - 1, ps + 1, ps + numleft);
        root.right = build(pre, pos, ipos + 1, ie, ps + numleft + 1, pe);
        return root;
    }
}