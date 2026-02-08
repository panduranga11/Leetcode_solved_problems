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
    public boolean isBalanced(TreeNode root) {
     if(check(root)==-1){
        return false;
      }  
      return true;
}
public int check(TreeNode root){
    if(root==null){
        return 0;
    }
    int left=check(root.left);
    int right=check(root.right);
    if(left==-1 || right==-1){
        return -1;
    }
    if(Math.abs(left-right)>1){
        return -1;
    
    }
    return Math.max(left,right)+1;
}
}




///0(N^2) solution but beats 100 percent


//  if(root==null){
//             return true;
//         }
//        int leftheight=maxDepth(root.left);
//        int rightheight=maxDepth(root.right);
//        if(Math.abs(leftheight-rightheight)>1){
//         return false;
//        }
//        boolean left=isBalanced(root.left);
//        if(!left){
//         return false;
//        }
//        boolean right=isBalanced(root.right);
//        if(!right){
//         return false;
//        }
       
//        return true;

//     }
   
//     public int maxDepth(TreeNode root) {
//         if(root==null){
//             return 0;
//         }
//         int l=1+maxDepth(root.left);
//         int r=1+maxDepth(root.right);
//         return Math.max(l,r);
        
//     }




