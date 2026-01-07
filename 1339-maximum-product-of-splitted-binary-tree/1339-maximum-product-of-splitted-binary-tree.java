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
   long max=0;

    public int maxProduct(TreeNode root) {
          max = 0; 
        
       long totalsum= totalsum(root); 
      
     maxsum(root,totalsum);
    return (int)(max%1000000007);
    }
    public  long maxsum(TreeNode root,long tsum){
        if(root==null){
            return 0;
        }
        long lsum=0;
        long rsum=0;
        lsum+=maxsum(root.left,tsum);
        rsum+=maxsum(root.right,tsum);
        long subsum= lsum+rsum+root.val;
        long remain=tsum-subsum;
        max=Math.max(max,subsum*remain);
   
        return subsum;
    }
    public long totalsum(TreeNode root){
        if(root==null){
            return 0;
        }
        
        return root.val+ totalsum(root.left)+totalsum(root.right);
       
        
        
        
        
       
    }
}