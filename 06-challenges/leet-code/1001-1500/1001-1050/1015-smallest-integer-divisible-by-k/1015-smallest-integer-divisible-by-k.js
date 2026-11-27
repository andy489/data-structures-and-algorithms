// https://leetcode.com/problems/smallest-integer-divisible-by-k/

var smallestRepunitDivByK = function(k) {
    if (k % 2 === 0 || k % 5 === 0) return -1;
    let rem = 0;
    for (let len = 1; len <= k; len++) {
        rem = (rem * 10 + 1) % k;
        if (rem === 0) return len;
    }
    return -1;
};
