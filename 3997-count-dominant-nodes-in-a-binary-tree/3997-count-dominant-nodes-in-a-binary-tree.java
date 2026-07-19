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
    int count=0;
    public int countDominantNodes(TreeNode root) {
      solve(root);
        return count;
    }
    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=solve(root.left);
        int right=solve(root.right);
        if(root.val>=Math.max(left,right)){
          //  System.out.println(root.val);
            count++;
        }
        return Math.max(root.val,Math.max(left,right));
    }
    
}