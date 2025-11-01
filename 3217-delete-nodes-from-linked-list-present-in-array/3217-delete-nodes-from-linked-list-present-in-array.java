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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums){
            hs.add(i);
        }
        if(head==null){
            return head;
        }
       
        ListNode dummy =new ListNode(-1);
        dummy.next=head;
        ListNode temp=dummy;

        
        while(temp!=null){
            ListNode inc=temp.next;
            while( inc!=null &&hs.contains(inc.val) ){
             
              inc=inc.next;
            }
            temp.next=inc;
            temp=temp.next;
            
        }
        return dummy.next;

    }
}