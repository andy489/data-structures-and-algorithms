// https://leetcode.com/problems/maximum-balanced-subsequence-sum/

var maxBalancedSubsequenceSum = function(nums) {
    const n = nums.length;
    const a = nums.map((v, i) => v - i);
    const sorted = [...new Set(a)].sort((x, y) => x - y);
    const rank = new Map(sorted.map((v, i) => [v, i]));
    const m = sorted.length;
    const bit = new Array(m + 1).fill(-Infinity);

    function update(pos, val) {
        for (pos++; pos <= m; pos += pos & (-pos)) {
            if (bit[pos] < val) bit[pos] = val;
        }
    }

    function query(pos) {
        let res = -Infinity;
        for (pos++; pos > 0; pos -= pos & (-pos)) {
            if (bit[pos] > res) res = bit[pos];
        }
        return res;
    }

    let ans = -Infinity;
    for (let i = 0; i < n; i++) {
        const pos = rank.get(a[i]);
        const prev = query(pos);
        const dp = nums[i] + (prev > 0 ? prev : 0);
        ans = Math.max(ans, dp);
        update(pos, dp);
    }
    return ans;
};
