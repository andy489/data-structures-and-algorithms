// https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

var findMinFibonacciNumbers = function(k) {
    const fibs = [1, 1];
    while (fibs[fibs.length-1] < k) fibs.push(fibs[fibs.length-1] + fibs[fibs.length-2]);
    let count = 0;
    for (let i = fibs.length-1; i >= 0 && k > 0; i--)
        if (fibs[i] <= k) { k -= fibs[i]; count++; }
    return count;
};
