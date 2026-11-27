// https://leetcode.com/problems/delete-node-in-a-linked-list/

// Solution: Copy-and-Skip — O(1) time, O(1) space
var deleteNode = function(node) {
    node.val = node.next.val;
    node.next = node.next.next;
};
