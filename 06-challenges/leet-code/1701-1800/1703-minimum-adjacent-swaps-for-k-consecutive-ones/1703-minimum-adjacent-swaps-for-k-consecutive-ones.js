// https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/

var minMoves = function(nums, k) {
    const pos = [];
    let idx = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 1) {
            pos.push(i - idx++);
        }
    }
    const m = pos.length;
    const prefix = new Array(m + 1).fill(0);
    for (let i = 0; i < m; i++) {
        prefix[i + 1] = prefix[i] + pos[i];
    }
    let result = Infinity;
    for (let i = 0; i + k <= m; i++) {
        const mid = i + Math.floor(k / 2);
        const leftCost = pos[mid] * (mid - i) - (prefix[mid] - prefix[i]);
        const rightCost = (prefix[i + k] - prefix[mid + 1]) - pos[mid] * (i + k - mid - 1);
        result = Math.min(result, leftCost + rightCost);
    }
    return result;
};
