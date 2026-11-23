// https://leetcode.com/problems/count-of-range-sum/

// Solution: Merge Sort on Prefix Sums — O(n log n) time, O(n) space
var countRangeSum = function(nums, lower, upper) {
    const prefix = new Array(nums.length + 1).fill(0);
    for (let i = 0; i < nums.length; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }
    let count = 0;

    function mergeSort(arr) {
        if (arr.length <= 1) return arr;
        const mid = Math.floor(arr.length / 2);
        const left = mergeSort(arr.slice(0, mid));
        const right = mergeSort(arr.slice(mid));
        let lo = 0, hi = 0;
        for (const l of left) {
            while (lo < right.length && right[lo] - l < lower) lo++;
            while (hi < right.length && right[hi] - l <= upper) hi++;
            count += hi - lo;
        }
        const merged = [];
        let i = 0, j = 0;
        while (i < left.length && j < right.length) {
            merged.push(left[i] <= right[j] ? left[i++] : right[j++]);
        }
        return merged.concat(left.slice(i)).concat(right.slice(j));
    }

    mergeSort(prefix);
    return count;
};
