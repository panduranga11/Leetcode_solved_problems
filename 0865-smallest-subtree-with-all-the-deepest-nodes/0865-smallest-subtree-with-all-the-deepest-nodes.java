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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
      
      return solve(root);  
}
public TreeNode solve(TreeNode root){
    
    TreeNode l=root.left;
    TreeNode r=root.right;
    if(height(l)==height(r)){
        return root;
    }else if(height(l)>height(r)){
       return solve(root.left);
    }else{
        return solve(root.right);
    }
    
}
public int height(TreeNode root){
    if(root==null){
        return 0;
    }
    int lh=0;
    int rh=0;
    if(root.left!=null){
        lh=height(root.left);
    }
    if(root.right!=null){
        rh=height(root.right);
    }
    return 1+Math.max(lh,rh);
    
}
}