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
//Iterative approach
//TC O(N)
//SC O(N)
public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res=new ArrayList();
        if(root==null){
            return res;
        }
        
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level=new ArrayList();
            int count=queue.size();
            for(int i=0;i<count;i++){
                TreeNode node=queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        
        return res;
    }
    
//Recursive approach
//TC O(N)
//SC O(N)
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res=new ArrayList();
        levelOrderhelper(root,res,0);
        return res;
    }
    
    private void levelOrderhelper(TreeNode node, List<List<Integer>> res, int level){
        if(node==null){
            return;
        }
        if(level>=res.size()){
            List<Integer> newLevel=new ArrayList();
            res.add(newLevel);
        }
        res.get(level).add(node.val);
        levelOrderhelper(node.left,res,level+1);
        levelOrderhelper(node.right,res,level+1);
    }
}