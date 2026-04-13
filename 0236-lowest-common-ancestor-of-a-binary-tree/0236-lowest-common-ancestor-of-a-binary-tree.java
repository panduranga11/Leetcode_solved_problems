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
    static {
        TreeNode root=null;
        for(int i=0;i<200;i++){
            lowestCommonAncestor(root,null,null);
        }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      TreeNode ans=findansistor(root,p,q);
      return ans;  
}
public static TreeNode findansistor(TreeNode root,TreeNode p,TreeNode q){
    
    if(root==p ||root==q||root==null){
        return root;
    }
    TreeNode left=findansistor(root.left,p,q);
    TreeNode right=findansistor(root.right,p,q);
    if(left!=null && right!=null){
        return root;
    }
    if(left!=null){
        return left;
    }
    if(right!=null){
        return right;
    }
    return null;


}
}


// ArrayList<TreeNode> arr1=new ArrayList<>();
//         ArrayList<TreeNode> arr2=new ArrayList<>();
//         path(root,p,arr1);
//         path(root,q,arr2);
//         int len=Math.min(arr1.size(),arr2.size());
//        TreeNode prev=arr1.get(0);
//         for(int i=1;i<len;i++){
//             if(arr1.get(i)!=arr2.get(i)){
//               return prev;  
//             }
//             prev=arr1.get(i);
//         }
//         return prev;

        

        
//     }
//     public boolean path(TreeNode root,TreeNode p,ArrayList<TreeNode> ans){
        

//         if(root==null){
//             return false;
//         }

//         ans.add(root);
//         if(root==p){
//             return true;
//         }
//        if( path(root.left,p,ans) || path(root.right,p,ans)){
//         return true;
//        }
       
//         ans.remove(ans.size()-1);
//         return false;
        
//     }