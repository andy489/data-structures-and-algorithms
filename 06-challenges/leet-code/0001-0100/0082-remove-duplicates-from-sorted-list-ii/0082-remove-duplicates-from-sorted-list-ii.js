// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

var deleteDuplicates = function(head) {
    const dummy = { val: 0, next: head };
    let prev = dummy;
    while (prev.next) {
        if (prev.next.next && prev.next.val === prev.next.next.val) {
            const val = prev.next.val;
            let curr = prev.next;
            while (curr && curr.val === val) curr = curr.next;
            prev.next = curr;
        } else {
            prev = prev.next;
        }
    }
    return dummy.next;
};
