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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        
        ListNode pointer1=head, pointer2=head;
        int size=1;
        while(pointer1.next!=null){
            size++;
            pointer1=pointer1.next;
        }
        k=k%size;
        for(int i=0;i<size-k-1;i++){
            pointer2=pointer2.next;
        }
        
        pointer1.next=head;
        ListNode newHead=pointer2.next;
        pointer2.next=null;
        
        return newHead;
    }
}