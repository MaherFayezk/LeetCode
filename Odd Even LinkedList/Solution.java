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
public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode odd=head, even=head.next,evenHead=even;
        
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
    public ListNode oddEvenList2(ListNode head) {
        if(head==null){
            return null;
        }
        List<Integer> even=new ArrayList();
        ListNode tempHead=head;
        while(tempHead.next!=null){
            even.add(tempHead.next.val);
            if(tempHead.next.next !=null){
                tempHead.next=tempHead.next.next;
                tempHead=tempHead.next;
            }else {
                break;
            }
            
        }
        
        for(Integer e:even){
            tempHead.next=new ListNode(e);
            tempHead=tempHead.next;
        }
        return head;
    }
}