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
//Recursive approach 
//O(n) SC 
//O(n) TC
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder=new ArrayList();
        postorderDFS(root,postorder);
        return postorder;
    }
    
    private void postorderDFS(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        
        postorderDFS(root.left, res);
        postorderDFS(root.right, res);
        res.add(root.val);
    }


//Iterative approach 
//O(n) SC 
//O(n) TC
 public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> postorder=new LinkedList();
        if(root==null){
            return postorder;
        }
        Stack<TreeNode> stack=new Stack();
        TreeNode current;
        stack.push(root);
        while(!stack.isEmpty()){
            current=stack.pop();
            postorder.addFirst(current.val);
            if(current.left!=null){
                stack.push(current.left);
            }
            if(current.right!=null){
                stack.push(current.right);
            }
        }
        return postorder;
    }
}