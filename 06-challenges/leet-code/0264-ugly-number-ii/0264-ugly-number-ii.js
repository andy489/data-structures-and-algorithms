// https://leetcode.com/problems/ugly-number-ii/

// Solution: Three-Pointer DP — O(n) time, O(n) space
var nthUglyNumber = function(n) {
    const ugly = new Array(n).fill(0);
    ugly[0] = 1;
    let p2 = 0, p3 = 0, p5 = 0;
    for (let i = 1; i < n; i++) {
        const next = Math.min(ugly[p2] * 2, ugly[p3] * 3, ugly[p5] * 5);
        ugly[i] = next;
        if (next === ugly[p2] * 2) p2++;
        if (next === ugly[p3] * 3) p3++;
        if (next === ugly[p5] * 5) p5++;
    }
    return ugly[n - 1];
};
