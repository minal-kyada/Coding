package WinterBreak.Day11;

// https://leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //Approach1: TC:O(n) SC:O(n)
        // if (head == null)
        //     return null;
        // Map<Node, Node> map = new HashMap<>();
        // Node curr = head;
        // Node prev = null;
        // Node newHead = null;

        // while (curr != null){
        //     Node temp = new Node(curr.val);
        //     map.put(curr,temp); //store
        //     if (newHead == null) {
        //         newHead = temp;
        //         prev = newHead;
        //     } else {
        //         prev.next = temp;
        //         prev = temp;
        //     }
        //     curr = curr.next;
        // }
        // //Fill random pointer
        // curr = head;
        // Node newCurr = newHead;
        // while (curr != null) {
        //     if (curr.random == null)
        //         newCurr.random = null;
        //     else 
        //         newCurr.random = map.get(curr.random);
        //     curr = curr.next;
        //     newCurr = newCurr.next;
        // }
        // return newHead;

        //Approach2: TC:O(n) SC:O(1)
        //1. Insert new nodes
        if (head == null)
            return null;      
        Node curr = head;
        while (curr != null) {
            Node currNext = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = currNext;
            curr = currNext;
        }  
        //2. Assign random pointers
        curr = head;
        while (curr != null && curr.next != null) {
            if (curr.random == null)
                curr.next.random = null;
            else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //3. Seperate old and new linked list
        curr = head;
        Node newHead = curr.next;
        Node newCurr = curr.next;
        while (curr != null && newCurr != null) {
            curr.next = curr.next == null ? null : curr.next.next;
            newCurr.next = newCurr.next == null ? null : newCurr.next.next;
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}
