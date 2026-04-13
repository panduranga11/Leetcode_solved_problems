/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int max=Math.max(p.val,q.val);
    int min=Math.min(p.val,q.val);
    return find(root,max,min);
    
    }
    public TreeNode find(TreeNode root,int max,int min){
        if(root==null){
            return null;
        }
        if(root.val>max){
            return find(root.left,max,min);
        }
        if(root.val<min){
            return find(root.right,max,min);

        }else{
            return root;
        }
    }
    
}