// https://leetcode.com/problems/minimum-absolute-sum-difference/

var minAbsoluteSumDiff = function(nums1, nums2) {
    const MOD = 1000000007n;
    const n = nums1.length;
    const sorted1 = [...nums1].sort((a, b) => a - b);

    function bsLeft(arr, target) {
        let lo = 0, hi = arr.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    let total = 0n, maxSave = 0n;
    for (let i = 0; i < n; i++) {
        const diff = BigInt(Math.abs(nums1[i] - nums2[i]));
        total += diff;
        const pos = bsLeft(sorted1, nums2[i]);
        if (pos < n) maxSave = BigInt(Math.max(Number(maxSave), Number(diff) - Math.abs(sorted1[pos] - nums2[i])));
        if (pos > 0) maxSave = BigInt(Math.max(Number(maxSave), Number(diff) - Math.abs(sorted1[pos - 1] - nums2[i])));
    }
    return Number((total - maxSave) % MOD);
};
