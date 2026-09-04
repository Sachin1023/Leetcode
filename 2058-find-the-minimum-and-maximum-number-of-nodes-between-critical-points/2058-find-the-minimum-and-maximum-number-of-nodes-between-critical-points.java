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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        return criticalPoints(head);
    }
    //find critical points. return int[] critical point indexis 
    public int[] criticalPoints(ListNode head)
    {
        // List<Integer> list = new ArrayList<>();
        ListNode prev=head;
        ListNode cur=prev.next;
    
        int firstCp=-1;
        int prevCP=-1;
        int min=Integer.MAX_VALUE;
        int max=-1;
        
        int index=2;
        while(cur.next!=null)
        {
            ListNode next=cur.next;
            //check for local minima and local maxima. critical points
            if (( prev.val > cur.val && cur.val < next.val ) || ( prev.val < cur.val && cur.val > next.val ) )
            {
                if(firstCp==-1) firstCp=index;
                else{
                    min=Math.min(min,index-prevCP);
                    max=index-firstCp;
                }
                prevCP=index;

            }
            index++;
            prev=cur;
            cur=next;
        }
        if(max == -1) return new int[]{-1,-1};
        return new int[] {min,max};
    } 
}