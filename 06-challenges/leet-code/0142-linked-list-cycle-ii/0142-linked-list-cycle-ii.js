// https://leetcode.com/problems/linked-list-cycle-ii/

// Solution 1: HashSet — O(n) time, O(n) space
var detectCycle = function(head) {
    const seen = new Set();
    let cur = head;
    while (cur) {
        if (seen.has(cur)) return cur;
        seen.add(cur);
        cur = cur.next;
    }
    return null;
};

// Solution 2: Floyd's Cycle Detection — O(n) time, O(1) space
var detectCycle2 = function(head) {
    let slow = head, fast = head;
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow === fast) {
            slow = head;
            while (slow !== fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
    return null;
};
