// https://leetcode.com/problems/beautiful-arrangement-ii/

var constructArray = function(n, k) {
    const res = [];
    let lo = 1, hi = k + 1;
    for (let i = 0; i < k + 1; i++) {
        res.push(i % 2 === 0 ? lo++ : hi--);
    }
    for (let i = k + 2; i <= n; i++) {
        res.push(i);
    }
    return res;
};
