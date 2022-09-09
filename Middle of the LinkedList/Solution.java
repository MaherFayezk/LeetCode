/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
 public ListNode middleNode(ListNode head) {
        if(head==null)return head;
        ListNode p1=head;
        ListNode p2=head;
        
        while(p2!=null && p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            
        }
        
        return p1;
        
    }
    public ListNode middleNode1(ListNode head) {
        if(head==null)return head;
        ListNode iterator=head;
        int size=0;
        while(iterator!=null){
            size++;
            iterator=iterator.next;
        }
        iterator=head;
        
        for(int i=0;i<size/2;i++){
            iterator=iterator.next;
        }
        
        return iterator;
        
    }
}