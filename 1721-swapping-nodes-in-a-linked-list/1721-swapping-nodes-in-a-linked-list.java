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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode first=dummy;
        ListNode second=dummy;
         for(int i=0;i<k;i++){
            first=first.next;
            
        }
        System.out.println(first.val);
        ListNode n1=first;
        while(first.next!=null){
            first=first.next;
            second=second.next;
           

        }
        ListNode n2=second.next;
        System.out.println(n2.val);
        int t=n1.val;
        n1.val=n2.val;
        n2.val=t;
        return dummy.next;
    }
}