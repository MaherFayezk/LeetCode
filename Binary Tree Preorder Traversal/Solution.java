
class Solution {
    
//Iterative approach
//TC O(n)
//SC O(n) for the stack
public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> preorderList=new LinkedList();
        if (root ==null){
            return preorderList;
        }
        Stack<TreeNode> stack=new Stack();
        
        while (root!=null){
            preorderList.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left==null && !stack.isEmpty()){
                root=stack.pop();
            }else {
                root=root.left;
            }
        }
        return preorderList;
   }

//Recursive approach
//TC O(n)
//SC O(n) for the recursion call stack
public List<Integer> preorderTraversal1(TreeNode root) {
        
        List<Integer> preorderList=new LinkedList();
        if (root ==null){
            return preorderList;
        }
        dfs(root, preorderList);
        return preorderList;
    }
    
    private void dfs(TreeNode root, List<Integer> values){
        if(root==null)return;
        values.add(root.val);
        dfs(root.left, values);
        dfs(root.right, values);
    }
}