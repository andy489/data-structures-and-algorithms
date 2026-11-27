// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/

var minimumMountainRemovals = function(nums) {
    const n = nums.length;
    const lis = new Array(n).fill(1);
    const lds = new Array(n).fill(1);
    for (let i = 1; i < n; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
    }
    for (let i = n - 2; i >= 0; i--) {
        for (let j = i + 1; j < n; j++) {
            if (nums[j] < nums[i]) {
                lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }
    }
    let maxMountain = 0;
    for (let i = 1; i < n - 1; i++) {
        if (lis[i] > 1 && lds[i] > 1) {
            maxMountain = Math.max(maxMountain, lis[i] + lds[i] - 1);
        }
    }
    return n - maxMountain;
};
