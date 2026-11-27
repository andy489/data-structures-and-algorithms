// https://leetcode.com/problems/finding-3-digit-even-numbers/

// Solution: Enumerate — O(1) time, O(1) space
var findEvenNumbers = function(digits) {
    const freq = new Array(10).fill(0);
    for (const d of digits) freq[d]++;
    const res = [];
    for (let num = 100; num <= 998; num += 2) {
        const used = new Array(10).fill(0);
        let tmp = num;
        while (tmp > 0) { used[tmp % 10]++; tmp = Math.floor(tmp / 10); }
        if (used.every((u, i) => u <= freq[i])) res.push(num);
    }
    return res;
};
