// https://leetcode.com/problems/add-two-numbers/

var addTwoNumbers = function(l1, l2) {
    let dummy = { val: 0, next: null };
    let cur = dummy;
    let carry = 0;

    while (l1 !== null || l2 !== null) {
        let sum = carry;
        if (l1 !== null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 !== null) {
            sum += l2.val;
            l2 = l2.next;
        }
        carry = Math.floor(sum / 10);
        cur.next = { val: sum % 10, next: null };
        cur = cur.next;
    }

    if (carry > 0) {
        cur.next = { val: carry, next: null };
    }

    return dummy.next;
};
