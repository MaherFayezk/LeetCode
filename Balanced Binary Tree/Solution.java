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
    boolean balanced=true;
    public boolean isBalanced(TreeNode root) {
        validate(root);
        return balanced;
    }
     private int validate(TreeNode root){
        if(root==null){
            return 0;
        }
        int left =validate(root.left);
        int right=validate(root.right);
        if(Math.abs(left-right)>1){
            balanced=false;
        }
         return Math.max(left,right)+1;
    }
}