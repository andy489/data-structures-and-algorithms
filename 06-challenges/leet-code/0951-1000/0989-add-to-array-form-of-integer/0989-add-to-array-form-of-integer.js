// https://leetcode.com/problems/add-to-array-form-of-integer/

var addToArrayForm = function(num, k) {
    const res = [];
    let i = num.length - 1;
    while (i >= 0 || k) {
        if (i >= 0) k += num[i--];
        res.push(k % 10);
        k = Math.floor(k / 10);
    }
    return res.reverse();
};
