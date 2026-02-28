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
    public int sumRootToLeaf(TreeNode root) {
return sum(root,0);

        
    }
    public int sum(TreeNode root,int c){
        
        if(root.left==null && root.right==null){
           
            return c<<1 |root.val;
        }
        
        int s1=0;
        int s2=0;
        if(root.left!=null){
         s1=sum(root.left,(c<<1) |root.val);
        }
        if(root.right!= null){
         s2=sum(root.right,(c<<1) |root.val);
        }
        return s1+s2;

        
    }
}