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

//Iterative Approach 
//O(n) for both
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        int level=0;
        
        while(!queue.isEmpty()){
            int count=queue.size();
            List<Integer> levelValues=new LinkedList();
            TreeNode node;
            for(int i=0;i<count;i++){
                node=queue.poll();
                if(level%2==0){
                    levelValues.add(node.val);
                }else {
                    levelValues.add(0,node.val);
                }
                 if(node.left!=null){
                     queue.add(node.left);
                }
                if(node.right!=null){
                     queue.add(node.right);
                }
            }
            level+=1;
            res.add(levelValues);
            
        }
        return res;
    }
    

//Recursive Approach 
//O(n)
//O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList();
        levelOrderhelper(root,res,0);
        return res;
    }
    
    private void levelOrderhelper(TreeNode node, List<List<Integer>> res, int level){
        if(node==null){
            return;
        }
        if(level>=res.size()){
            List<Integer> newLevel=new LinkedList();
            res.add(newLevel);
        }
        if(level%2==0){
            res.get(level).add(node.val);
        }else {
            res.get(level).add(0,node.val);
        }
        levelOrderhelper(node.left,res,level+1);
        levelOrderhelper(node.right,res,level+1);
   
    }
}