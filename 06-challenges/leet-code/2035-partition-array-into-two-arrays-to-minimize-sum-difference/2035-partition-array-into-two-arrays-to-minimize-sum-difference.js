// https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/

// Solution: Meet in the Middle — O(2^n * n) time, O(2^n) space
var minimumDifference = function(nums) {
    const n = nums.length >> 1;
    const total = nums.reduce((a, b) => a + b, 0);
    const leftSums = Array.from({length: n+1}, () => []);
    const rightSums = Array.from({length: n+1}, () => []);
    for (let mask = 0; mask < (1 << n); mask++) {
        let sl = 0, sr = 0, bl = 0;
        for (let i = 0; i < n; i++) {
            if (mask >> i & 1) { sl += nums[i]; sr += nums[i+n]; bl++; }
        }
        leftSums[bl].push(sl);
        rightSums[bl].push(sr);
    }
    for (const lst of rightSums) lst.sort((a,b) => a-b);
    const bs = (arr, t) => { let lo=0, hi=arr.length; while(lo<hi){const m=(lo+hi)>>1; arr[m]<t?lo=m+1:hi=m;} return lo; };
    let res = Infinity;
    for (let k = 0; k <= n; k++) {
        const rs = rightSums[n-k];
        for (const ls of leftSums[k]) {
            const target = Math.floor(total/2) - ls;
            const pos = bs(rs, target);
            for (const p of [pos-1, pos]) {
                if (p >= 0 && p < rs.length) res = Math.min(res, Math.abs(total - 2*(ls+rs[p])));
            }
        }
    }
    return res;
};
