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
    int ans=0;
    public int minCameraCover(TreeNode root) {
   
 if(solve(root)==0){
    ans++;
 }
 return ans;
    }
    public int solve(TreeNode root){
       if(root==null){
        return 2;
       }
       int l=solve(root.left);
       int r=solve(root.right);
       
       if(l==0 || r==0){
ans++;
return 1;
       }
       if(l==2 && r==2){
        return 0;
       }
       return 2;
    }
}