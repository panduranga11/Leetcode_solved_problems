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
    public TreeNode insertIntoBST(TreeNode root, int val) {
       TreeNode cur=root;
       
       TreeNode nn=new TreeNode(val);
       if(root==null){
        return nn;
       }
       while(cur!=null){
        if(val<=cur.val){
            if(cur.left==null){
                cur.left=nn;
                break;
            }else{
                cur=cur.left;
            }
        }else{
            if(cur.right==null){
                cur.right=nn;
                break;
            }else{
                cur=cur.right;
            }
        }
       } 
       return root;
    }

}