// https://leetcode.com/problems/merge-two-sorted-lists/

// Solution: Iterative (Dummy Head) — O(n + m) time, O(1) space
var mergeTwoLists = function(list1, list2) {
    const dummy = new ListNode(0);
    let curr = dummy;

    while (list1 !== null && list2 !== null) {
        if (list1.val <= list2.val) {
            curr.next = list1;
            list1 = list1.next;
        } else {
            curr.next = list2;
            list2 = list2.next;
        }
        curr = curr.next;
    }

    curr.next = list1 !== null ? list1 : list2;
    return dummy.next;
};

// Solution2: Recursive — O(n + m) time, O(n + m) space
var mergeTwoLists2 = function(list1, list2) {
    if (list1 === null) return list2;
    if (list2 === null) return list1;

    if (list1.val <= list2.val) {
        list1.next = mergeTwoLists2(list1.next, list2);
        return list1;
    } else {
        list2.next = mergeTwoLists2(list1, list2.next);
        return list2;
    }
};
