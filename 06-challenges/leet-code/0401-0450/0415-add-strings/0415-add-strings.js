// https://leetcode.com/problems/add-strings/

var addStrings = function(num1, num2) {
    let i = num1.length - 1, j = num2.length - 1, carry = 0;
    const digits = [];
    while (i >= 0 || j >= 0 || carry !== 0) {
        let sum = carry;
        if (i >= 0) { sum += num1.charCodeAt(i--) - 48; }
        if (j >= 0) { sum += num2.charCodeAt(j--) - 48; }
        digits.push(sum % 10);
        carry = Math.floor(sum / 10);
    }
    return digits.reverse().join('');
};
