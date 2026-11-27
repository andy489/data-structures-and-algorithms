// https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-ii/
var incremovableSubarrayCount = function(nums) {
    const n = nums.length;
    let prefixEnd = 0;
    while (prefixEnd + 1 < n && nums[prefixEnd] < nums[prefixEnd + 1]) {
        prefixEnd++;
    }
    if (prefixEnd === n - 1) {
        return BigInt(n) * BigInt(n + 1) / 2n;
    }
    let count = BigInt(n - prefixEnd);
    let j = n - 1;
    for (let i = prefixEnd; i >= 0; i--) {
        while (j >= 0 && (i === 0 || nums[i - 1] < nums[j])) {
            j--;
        }
        count += BigInt(n - (j + 1));
        if (i > 0 && nums[i - 1] >= nums[i]) {
            break;
        }
    }
    return count;
};
