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
    int count(ListNode head)
    {
        ListNode temp=head;
        int c=0;
        while(temp!=null)
        {
            c++;
            temp=temp.next;
        }
        return c;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
        return head;
        ListNode temp=head;
        int c=count(head);
        k=k%c;
        if(k==0)
        return head;
         for (int p = 0; p < c - k - 1; p++) 
        {
            temp=temp.next;
        }
        ListNode temp1=temp.next;
        ListNode head1=temp1;
        temp.next=null;
        while(temp1.next!=null)
        {
            temp1=temp1.next;
        }
        temp1.next=head;
        return head1;
    }
}