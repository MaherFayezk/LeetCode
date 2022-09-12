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


//O(n) SC &TC
 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left, p,q);
        TreeNode right=lowestCommonAncestor(root.right, p,q);
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else {
            return root;
        }
    }




//Using 2 stacks 
//O(n) for TC and O(2n) SC
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pPath=getPath(root,p);
        Stack<TreeNode> qPath=getPath(root,q);
        if(pPath==null||qPath==null){
            return null;
        }
        TreeNode lca=null;
        while(!pPath.isEmpty()&&!qPath.isEmpty()){
            TreeNode pNode=pPath.pop();
            TreeNode qNode=qPath.pop();
            if(pNode==qNode){
                lca=pNode;
            }else {
                break;
            }
        }
        return lca;
    }
    
    private Stack<TreeNode> getPath(TreeNode root, TreeNode node ){
        if(root==null){
            return null;
        }
        if(root.val==node.val){
            Stack<TreeNode> path=new Stack();
            path.push(root);
            return path;
        }
        Stack<TreeNode> leftPath=getPath(root.left, node);
        if(leftPath!=null){
            leftPath.push(root);
            return leftPath;
        }
        Stack<TreeNode> rightPath=getPath(root.right, node);
        if(rightPath!=null){
            rightPath.push(root);
            return rightPath;
        }
        return null;
    }
}