// https://leetcode.com/problems/adding-two-negabinary-numbers/

var addNegabinary = function(arr1, arr2) {
    let i = arr1.length-1, j = arr2.length-1, carry = 0;
    const res = [];
    while (i >= 0 || j >= 0 || carry !== 0) {
        const a = i >= 0 ? arr1[i--] : 0;
        const b = j >= 0 ? arr2[j--] : 0;
        const s = a + b + carry;
        res.push(s & 1);
        carry = -(s >> 1);
    }
    while (res.length > 1 && res[res.length-1] === 0) res.pop();
    return res.reverse();
};
