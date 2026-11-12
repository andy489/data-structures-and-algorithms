// https://leetcode.com/problems/add-binary/

// Solution: Right-to-left scan with carry — O(n) time, O(n) space
var addBinary = function(a, b) {
    let res = '', i = a.length - 1, j = b.length - 1, carry = 0;
    while (i >= 0 || j >= 0 || carry) {
        let sum = carry;
        if (i >= 0) sum += Number(a[i--]);
        if (j >= 0) sum += Number(b[j--]);
        res = (sum % 2) + res;
        carry = Math.floor(sum / 2);
    }
    return res;
};
