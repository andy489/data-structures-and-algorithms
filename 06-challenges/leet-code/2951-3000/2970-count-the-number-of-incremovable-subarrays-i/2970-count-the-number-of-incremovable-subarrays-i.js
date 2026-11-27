// https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/
var incremovableSubarrayCount = function(nums) {
    const n = nums.length;
    let count = 0;
    const isStrictlyIncreasing = (arr) => {
        for (let i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) return false;
        }
        return true;
    };
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            const remaining = [...nums.slice(0, i), ...nums.slice(j + 1)];
            if (isStrictlyIncreasing(remaining)) {
                count++;
            }
        }
    }
    return count;
};
