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


//The brute force solution using Stack 
//Or reversing the LinkedList and compare the original with the reversed 
//Both takes O(n) TC and O(n) SC
class Solution {
    //This approach will take constant SC 
    //Reverse Only the first half of the LinkedList
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        
        ListNode pointer1=head;
        ListNode pointer2=head;
        
        while(pointer2!=null && pointer2.next!=null){
            pointer2=pointer2.next.next;
            pointer1=pointer1.next;
        }
        if(pointer2!=null){
            pointer1=pointer1.next;
        }
        pointer1=reverse(pointer1);
        pointer2=head;
        while(pointer1!=null){
            if(pointer1.val!=pointer2.val){
                return false;
            }
            pointer2=pointer2.next;
            pointer1=pointer1.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode newHead=null;
        while(head !=null){
            ListNode temp=head.next;
            head.next=newHead;
            newHead=head;
            head=temp;
        }
        
        return newHead;
    }
}