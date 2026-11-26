// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

var swapNodes = function(head, k) {
    let front = head;
    for (let i = 1; i < k; i++) {
        front = front.next;
    }
    let back = head, cur = front;
    while (cur.next !== null) {
        cur = cur.next;
        back = back.next;
    }
    [front.val, back.val] = [back.val, front.val];
    return head;
};
