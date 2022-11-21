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

//We can solve this using 2 stacks 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        
        int carry=0;
        ListNode dummyHead=new ListNode();
        ListNode head=dummyHead;
        while(l1!=null || l2!=null || carry!=0){
            int sum=l1!=null?l1.val:0;
            sum+=l2!=null?l2.val:0;
            sum+=carry;
            carry=sum/10;
            dummyHead.next=new ListNode(sum%10);
            dummyHead=dummyHead.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        ListNode realHead=reverse(head.next);
        return realHead;
    }
    
    private ListNode reverse(ListNode head){
        ListNode newHead=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=newHead;
            newHead=head;
            head=next;
        }
        return newHead;
    }
}