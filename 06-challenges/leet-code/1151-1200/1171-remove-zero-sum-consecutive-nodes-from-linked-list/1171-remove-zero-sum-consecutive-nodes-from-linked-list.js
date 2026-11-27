// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

var removeZeroSumSublists = function(head) {
    const dummy = { val: 0, next: head };
    const prefixMap = new Map();
    let prefix = 0;
    for (let node = dummy; node !== null; node = node.next) {
        prefix += node.val;
        prefixMap.set(prefix, node);
    }
    prefix = 0;
    for (let node = dummy; node !== null; node = node.next) {
        prefix += node.val;
        node.next = prefixMap.get(prefix).next;
    }
    return dummy.next;
};
