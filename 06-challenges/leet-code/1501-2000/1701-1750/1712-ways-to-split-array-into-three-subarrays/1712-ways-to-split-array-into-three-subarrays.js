// https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/

var waysToSplit = function(nums) {
    const MOD = 1_000_000_007n;
    const n = nums.length;
    const pre = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        pre[i + 1] = pre[i] + nums[i];
    }

    let result = 0n;
    for (let i = 0; i < n - 2; i++) {
        const leftSum = pre[i + 1];
        if (leftSum * 3 > pre[n]) {
            break;
        }
        // min j: pre[j+1] - pre[i+1] >= leftSum
        let lo = i + 1, hi = n - 2;
        let minJ = n;
        while (lo <= hi) {
            const mid = (lo + hi) >> 1;
            if (pre[mid + 1] - pre[i + 1] >= leftSum) {
                minJ = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (minJ >= n - 1) {
            break;
        }
        // max j: mid sum <= right sum
        lo = minJ;
        hi = n - 2;
        let maxJ = minJ - 1;
        while (lo <= hi) {
            const mid = (lo + hi) >> 1;
            const midSum = pre[mid + 1] - pre[i + 1];
            const rightSum = pre[n] - pre[mid + 1];
            if (midSum <= rightSum) {
                maxJ = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (maxJ >= minJ) {
            result = (result + BigInt(maxJ - minJ + 1)) % MOD;
        }
    }
    return Number(result);
};
