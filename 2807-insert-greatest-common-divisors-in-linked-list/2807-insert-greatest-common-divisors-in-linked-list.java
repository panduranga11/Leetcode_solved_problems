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
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode temp=head;
        while(temp.next!=null){
            int data =gcd(temp.val,temp.next.val);
            ListNode nn=new ListNode(data);
            ListNode t1=temp.next;
            temp.next=nn;
            nn.next=t1;
            temp=t1;
        }
        return head;
        
    }
}