// https://leetcode.com/problems/linked-list-cycle/

var hasCycle = function(head) {
    let slow = head, fast = head;
    while (fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow === fast) {
            return true;
        }
    }
    return false;
};

var hasCycle2 = function(head) {
    const visited = new Set();
    let cur = head;
    while (cur !== null) {
        if (visited.has(cur)) {
            return true;
        }
        visited.add(cur);
        cur = cur.next;
    }
    return false;
};

var hasCycle3 = function(head) {
    const visited = new Set();
    function detect(node) {
        if (node === null) return false;
        if (visited.has(node)) return true;
        visited.add(node);
        return detect(node.next);
    }
    return detect(head);
};
