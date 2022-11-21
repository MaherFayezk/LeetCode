/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {




//TC O(n)
//SC O(1)
public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast){//overlap found
                ListNode start=head;
                while(start!=slow){
                    start=start.next;
                    slow=slow.next;
                }
                return start;
            }
        }
        return null;
    }

//TC O(n)
//SC O(n)

    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> nodes=new HashSet();
        
        ListNode iterator=head;
        
        while(iterator!=null){
            if(!nodes.contains(iterator)){
                nodes.add(iterator);
            }else {
                return iterator;
            }
            iterator=iterator.next;
        }
        return null;
    }
}