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
    public int averageOfSubtree(TreeNode root) {
       avg(root); 
       return count;
    }
    public int avg(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=avg(root.left);
        int right=avg(root.right);
        int s=sum(root);
        if(s/(left+right+1)==root.val){
            count++;
        }
        return left+right+1;
    }
    public int sum(TreeNode root){
if(root==null){
    return 0;
}
int left=sum(root.left);
int right=sum(root.right);
return left+right+root.val;
    }
}