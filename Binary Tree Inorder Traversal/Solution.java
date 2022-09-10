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

//Recursive Approach 
//O(n) TC 
//O(n) SC
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder=new ArrayList();
        inorderDFS(root,inorder);
        return inorder;
    }
    
    private void inorderDFS(TreeNode root, List<Integer> inorder){
        if(root==null){
            return;
        }
        inorderDFS(root.left,inorder);
        inorder.add(root.val);
        inorderDFS(root.right,inorder);
    }

//Iterative Approach 
//O(n) TC 
//O(n) SC
 public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> inorder=new ArrayList();
        Stack<TreeNode> stack=new Stack();
        TreeNode current=root;
        while(current!=null || !stack.isEmpty()){
            
            while(current!=null){
                stack.push(current);
                current=current.left;
            }
            current=stack.pop();
            inorder.add(current.val);
            current=current.right;
        }
        return inorder;
    }
}