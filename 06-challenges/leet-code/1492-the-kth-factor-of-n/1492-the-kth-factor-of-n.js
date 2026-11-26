// https://leetcode.com/problems/the-kth-factor-of-n/

var kthFactor = function(n, k) {
    for (let i = 1; i <= n; i++)
        if (n % i === 0 && --k === 0) return i;
    return -1;
};
