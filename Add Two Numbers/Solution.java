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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOn=0;
        ListNode dummuHead= new ListNode();
        ListNode iterator=dummuHead;
    
        while(l1 !=null || l2!=null || carryOn!=0){
            int additionResult=0;
            additionResult+= (l1 !=null)? l1.val:0;
            additionResult+= (l2 !=null)? l2.val:0;
            
            additionResult+=carryOn;
            carryOn=additionResult/10;
            
            iterator.next=new ListNode(additionResult%10);
            iterator=iterator.next;
            
           if(l1 !=null){
                l1= l1.next;
           }
            if(l2!=null){
                l2=l2.next;
            }
        }
    
        return dummuHead.next;
    }
    
}