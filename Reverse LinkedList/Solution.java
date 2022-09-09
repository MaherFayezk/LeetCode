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

//Brute force Solution can be done using a stack O(n) SC 

//O(n) TC
//O(1) SC
    public ListNode reverseList(ListNode head) {
	if(head==null || head.next==null) return head;
        ListNode newHead=null;
        while(head !=null){
            ListNode temp=head.next;
            head.next=newHead;
            newHead=head;
            head=temp;
        }
        
        return newHead;
        
    }

//Recursive approach
 public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newHead=null;
        
        return reverse(head,newHead);
        
    }
    private ListNode reverse(ListNode head, ListNode newHead){
        if(head==null){
            return newHead;
        }
        ListNode temp=head.next;
        head.next=newHead;
        return reverse(temp,head);
    }
}