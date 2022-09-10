/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

 //this approach takes linear time and constant speace 
    public Node copyRandomList(Node head) {
        
        if(head==null){
            return head;
        }
        
        Node node=head;
        while(node!=null){
            Node temp=node.next;
            node.next=new Node(node.val,temp,null);
            node=temp;
        }
        node=head;
        
        while(node!=null){
            if(node.random!=null){
                //This is beacuse the current random is the original and 
                //we want to point to the new node. so we point to 
                //node.random.next
                node.next.random=node.random.next;
            }
            node=node.next.next;
        }
        
        node=head;
        Node newHead=head.next;        
        while(node!=null){
            Node temp=node.next.next;
            Node copy=node.next;
            node.next=temp;
            if(temp!=null){
                copy.next=temp.next;
            }
            node=temp;
        }
        
        return newHead;
    }

    //This solution is based on HashMap 
    //It takes linear time and linear speace 
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> nodesMap=new HashMap();
        
        Node node=head;
        
        while(node!=null){
            nodesMap.put(node,new Node(node.val));
            node=node.next;
        }
        node=head;
        
        while(node!=null){
            Node newNode =nodesMap.get(node);
            newNode.next=nodesMap.get(node.next);
            newNode.random=nodesMap.get(node.random);
            node=node.next;
        }
        return nodesMap.get(head);
    }
}