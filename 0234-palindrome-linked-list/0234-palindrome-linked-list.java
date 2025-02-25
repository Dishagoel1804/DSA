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
    ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null)
        return head;
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null)
        {
            ListNode cur=temp.next;
            temp.next=prev;
            prev=temp;
            temp=cur;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
        return true;
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second=reverse(slow);
        slow.next=null;
        ListNode temp1=head;
        while(second!=null)
        {
            if(temp1.val!=second.val)
            return false;
            temp1=temp1.next;
            second=second.next;
        }
        return true;
    }
}