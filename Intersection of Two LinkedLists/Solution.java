/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

//Using HashSet 
//TC O(n) we can choose the min list
//SC O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodes=new HashSet();
        ListNode pointer1=headA;
        ListNode pointer2=headB;
        
        while(pointer1!=null){
            nodes.add(pointer1);
            pointer1=pointer1.next;
        }
         while(pointer2!=null){
            if(nodes.contains(pointer2)){
                return pointer2;
            }
            pointer2=pointer2.next;
        }
        
        return null;
    }

//This solution creates a cycle in the linked listes and find the begining of the cycle
//This is CALLED Floyed's Algorithm   
 //TC O(n+m)
    //SC O(1)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        
        if(headA==null || headB==null) return null;
        ListNode pointer1=headA;
        
        while(pointer1.next!=null){
            pointer1=pointer1.next;
        }
        pointer1.next=headB;
        
        ListNode slow=headA;
        ListNode fast=headA;
        ListNode start= null;
        
         while(fast!=null &&fast.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
             if(slow==fast){
                start= headA;
                while(slow!=start){
                    slow=slow.next;
                    start=start.next;
                }
                break;
            }
        }
        pointer1.next=null;
        return start;
    }
}