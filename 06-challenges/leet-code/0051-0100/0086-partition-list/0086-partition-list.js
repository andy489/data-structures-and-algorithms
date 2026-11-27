// https://leetcode.com/problems/partition-list/

var partition = function(head, x) {
    const lessDummy = { val: 0, next: null };
    const greaterDummy = { val: 0, next: null };
    let less = lessDummy, greater = greaterDummy;
    let curr = head;
    while (curr) {
        if (curr.val < x) {
            less.next = curr;
            less = less.next;
        } else {
            greater.next = curr;
            greater = greater.next;
        }
        curr = curr.next;
    }
    greater.next = null;
    less.next = greaterDummy.next;
    return lessDummy.next;
};
