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
return sum(root,"");

        
    }
    public int sum(TreeNode root,String s){
        
        if(root.left==null && root.right==null){
            s+=root.val;
            return Integer.parseInt(s,2);
        }
        
        int s1=0;
        int s2=0;
        if(root.left!=null){
         s1=sum(root.left,s+root.val);
        }
        if(root.right!= null){
         s2=sum(root.right,s+root.val);
        }
        return s1+s2;

        
    }
}