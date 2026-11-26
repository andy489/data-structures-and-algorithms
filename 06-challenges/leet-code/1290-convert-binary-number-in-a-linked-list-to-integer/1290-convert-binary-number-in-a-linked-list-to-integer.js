// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

var getDecimalValue = function(head) {
    let res = 0;
    while (head) { res = (res << 1) | head.val; head = head.next; }
    return res;
};
