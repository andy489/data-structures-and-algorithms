// https://leetcode.com/problems/count-of-smaller-numbers-after-self/

// Solution: Merge Sort — O(n log n) time, O(n) space
var countSmaller = function(nums) {
    const n = nums.length;
    const counts = new Array(n).fill(0);
    const indexed = nums.map((v, i) => [i, v]);

    function mergeSort(arr) {
        if (arr.length <= 1) return arr;
        const mid = Math.floor(arr.length / 2);
        const left = mergeSort(arr.slice(0, mid));
        const right = mergeSort(arr.slice(mid));
        return merge(left, right);
    }

    function merge(left, right) {
        const result = [];
        let i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i][1] <= right[j][1]) {
                counts[left[i][0]] += j;
                result.push(left[i++]);
            } else {
                result.push(right[j++]);
            }
        }
        while (i < left.length) {
            counts[left[i][0]] += j;
            result.push(left[i++]);
        }
        while (j < right.length) result.push(right[j++]);
        return result;
    }

    mergeSort(indexed);
    return counts;
};
