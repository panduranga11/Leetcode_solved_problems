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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
          if(head==null||head.next==null){
            return head;
        }
        if(k==0){
            return head;
        }
        
      
        int rotations=k%len;
        for(int i=0;i<rotations;i++){
           head=rotatelist(head);
        }
        return head;
        

        
    }
    public ListNode rotatelist(ListNode head){
        
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        fast.next=head;
        head=fast;
        slow.next=null;
        return head;
    }
    
}