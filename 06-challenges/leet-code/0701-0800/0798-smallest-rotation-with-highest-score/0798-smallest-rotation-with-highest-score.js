// https://leetcode.com/problems/smallest-rotation-with-highest-score/

var bestRotation = function(nums) {
    const n = nums.length;
    const change = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        const lo = ((i - nums[i] + 1) % n + n) % n;
        const hi = i;
        change[lo]--;
        if (lo > hi) change[0]--;
        if (hi + 1 < n) change[hi + 1]++;
    }
    let best = 0, score = n, curr = n;
    for (let k = 1; k < n; k++) {
        curr += change[k];
        if (curr > score) { score = curr; best = k; }
    }
    return best;
};
