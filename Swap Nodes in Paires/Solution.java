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

//TC O(n)
//SC O(1)
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode iterator=dummyHead;
     
        while(iterator.next!=null && iterator.next.next !=null){
           ListNode firstNode=iterator.next;
            ListNode secondNode=iterator.next.next;
            iterator.next=secondNode;
            firstNode.next=secondNode.next;
            secondNode.next=firstNode;
            iterator=iterator.next.next;
        }
        return dummyHead.next;
    }
}