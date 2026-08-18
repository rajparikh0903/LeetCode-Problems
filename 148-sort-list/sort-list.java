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
    public ListNode mergeList(ListNode l1,ListNode l2)
    {
        ListNode dummyNode = new  ListNode(-1);
        ListNode temp = dummyNode;
        while(l1!=null&l2!=null)
        {
            if(l1.val < l2.val)
            {
                temp.next=l1;
                temp = l1;
                l1=l1.next;
            }
            else{
            temp.next=l2;
                temp = l2;
                l2=l2.next;
                
            }
        }
        if(l1!=null)
        {
            temp.next=l1;
        }
        else{
            temp.next=l2;

        }
        return dummyNode.next;
    } 
    public ListNode findMiddle(ListNode l1)
    {
        ListNode slow = l1;
        ListNode fast = l1;
        ListNode prev = null;

        while(fast != null && fast.next != null)
        {   prev=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)    
            {
                return head;
            }
        ListNode middle = findMiddle(head);
        ListNode rightHead= middle.next;
        middle.next=null;
        
        ListNode leftHead    = head;

        leftHead=sortList(leftHead);
        rightHead=sortList(rightHead);
        return mergeList(leftHead,rightHead);
    }

}