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

//Iterative approach 
//TC O(min(len(list1),len(list2))
//SC O(n+m)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }

        else if(list2==null){
            return list1;
        }
        ListNode merged=new ListNode();
        ListNode dummy=merged;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                merged.next=new ListNode(list1.val);
                list1=list1.next;
            }else {
                merged.next=new ListNode(list2.val);
                list2=list2.next;
            }
            merged=merged.next;
        }
        merged.next=list1==null?list2:list1;
        
        return dummy.next;
    } 

//Recursive approach 
//TC O(min(len(list1),len(list2))
//SC O(min(len(list1),len(list2))
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }

        else if(list2==null){
            return list1;
        }
        
        if(list1.val<=list2.val){
            return new ListNode(list1.val, mergeTwoLists(list1.next,list2));
        }else {
            return new ListNode(list2.val, mergeTwoLists(list1,list2.next));
        }
    }       
}
