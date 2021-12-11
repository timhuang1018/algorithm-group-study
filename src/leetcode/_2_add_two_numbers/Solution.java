package leetcode._2_add_two_numbers;

import other.ListNode;

public class Solution {
    //both linked list start at single digits and move on
    //start adding up by each digits until both linked list exhuasted
    //add a carry number for next round
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1), visitor = dummy;

        while(l1!=null || l2!=null){
            int firstVal = l1!=null ? l1.val : 0;
            int secondVal = l2!=null ? l2.val :0;
            int total = firstVal + secondVal + carry;

            visitor.next = new ListNode(total % 10);
            carry = total / 10;

            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            visitor = visitor.next;
        }

        if(carry!=0){
            visitor.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
