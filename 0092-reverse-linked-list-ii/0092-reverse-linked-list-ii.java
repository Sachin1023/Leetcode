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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right ) return head;
        ListNode cur = head;
        ListNode prev= null;
        ListNode beforeLeft=null;
        ListNode afterRight=null;
        ListNode startRev=null;
        int count=1;


        while(cur!=null)
        {
            if(count==left) //start reversing
            {   
                startRev=cur;
                while(count<=right)
                {   
                    ListNode next=cur.next;
                    cur.next=prev;
                    prev=cur;
                    cur=next;
                    count++;
                }
                afterRight=cur;
                break;
            }
            beforeLeft=cur;
            cur=cur.next;
            count++;
        }
        if(left>1)
            beforeLeft.next=prev;
        else
            head=prev;

        startRev.next=afterRight;


        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev=null;

        while(cur!=null)
        {   
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }

}