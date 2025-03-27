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
    int count(ListNode head)
    {
        ListNode temp=head;int c=0;
        while(temp!=null)
        {
            c++;
            temp=temp.next;
        }
        return c;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int a=count(head)/k;
        ListNode current=new ListNode(-1);
        ListNode traverse=current;
        ListNode temp=head;
        ListNode temp1=head;
        for(int i=1;i<=a;i++)
        {
            int p=1;
            while(p<k && temp1.next!=null)
            {
                temp1=temp1.next;
                p++;
            }
           
            ListNode nextgrp=temp1.next;
            temp1.next=null;
             current.next=reverse(temp);
            while(current.next!=null)
            {
                current=current.next;
            }
            current.next=nextgrp;
            temp=temp1=nextgrp;
        }
        return traverse.next;
    }
}