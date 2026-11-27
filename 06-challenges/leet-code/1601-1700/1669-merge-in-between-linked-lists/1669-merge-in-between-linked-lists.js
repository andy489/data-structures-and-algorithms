// https://leetcode.com/problems/merge-in-between-linked-lists/

var mergeInBetween = function(list1, a, b, list2) {
    let node = list1;
    for (let i = 0; i < a - 1; i++) {
        node = node.next;
    }
    const nodeBeforeA = node;
    for (let i = 0; i <= b - a + 1; i++) {
        node = node.next;
    }
    const nodeAfterB = node;
    nodeBeforeA.next = list2;
    let tail = list2;
    while (tail.next !== null) {
        tail = tail.next;
    }
    tail.next = nodeAfterB;
    return list1;
};
