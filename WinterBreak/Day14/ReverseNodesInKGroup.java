// https://leetcode.com/problems/reverse-nodes-in-k-group/description/

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
    // TC: O(2N) - O(n) for finding kthNode and O(n) for reversing LL
    // SC: O(1) - no space being used in the process
    private ListNode getKthNode(ListNode temp, int k) {
        k-=1;
        while(temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;
        ListNode temp = head;
        ListNode nextNode, prevNode = null;
        while (temp != null) {
            ListNode kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                    break;
                }
            } else {
                nextNode = kthNode.next;
                kthNode.next = null;
                reverseList(temp);
                if (temp == head) 
                    head = kthNode;
                else {
                    prevNode.next = kthNode;
                }
                prevNode = temp;
                temp = nextNode;
            }
        }
        return head;
    }

    private void reverseList(ListNode head) {
        ListNode prev = null;  
        ListNode current = head;
        
        while(current != null) { 
            ListNode next = current.next; 
            current.next = prev;
            prev = current;
            current = next;
        }
    }
}
