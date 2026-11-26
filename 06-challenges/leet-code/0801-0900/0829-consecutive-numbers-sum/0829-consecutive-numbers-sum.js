// https://leetcode.com/problems/consecutive-numbers-sum/

var consecutiveNumbersSum = function(n) {
    let count = 0;
    for (let k = 1; k * (k - 1) / 2 < n; k++) {
        const rem = n - k * (k - 1) / 2;
        if (rem % k === 0) { count++; }
    }
    return count;
};
