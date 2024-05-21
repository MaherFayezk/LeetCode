/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> map= new HashMap();
        dfs(map, node);
        return map.get(node);
    }
    private Node dfs(Map<Node,Node> map, Node node){
        if(node==null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        List<Node> neighbors= node.neighbors;
        Node copy=new Node(node.val, new ArrayList());
        map.put(node, copy);
        for(Node neighbor : neighbors){
            copy.neighbors.add(dfs(map,neighbor));
        }
        return copy;
    }
}