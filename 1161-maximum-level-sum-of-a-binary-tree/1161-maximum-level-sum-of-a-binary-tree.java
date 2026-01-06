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
    public int maxLevelSum(TreeNode root) {
       Queue<TreeNode>q=new LinkedList<>();
       int level=1;
       int l=1;
       int max=Integer.MIN_VALUE;
       q.offer(root);
       while(!q.isEmpty()){
        int s=q.size();
        int sum=0;
        for(int i=0;i<s;i++){
            TreeNode n=q.poll();
            if(n.left!=null){
                q.offer(n.left);
                
            }
            if(n.right!=null){
                q.offer(n.right);
            }
            sum+=n.val;
        }
        
        if(sum>max){
            max=sum;
            level=l;
            
        }
        l++;
       }
       return level;
    }
    
}