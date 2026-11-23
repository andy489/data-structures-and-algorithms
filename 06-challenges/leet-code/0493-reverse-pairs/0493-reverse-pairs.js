// https://leetcode.com/problems/reverse-pairs/

var reversePairs = function(nums) {
    const mergeSort = (arr) => {
        if (arr.length <= 1) return [arr, 0];
        const mid = Math.floor(arr.length / 2);
        const [left, lc] = mergeSort(arr.slice(0, mid));
        const [right, rc] = mergeSort(arr.slice(mid));
        let count = lc + rc;
        let j = 0;
        for (const x of left) {
            while (j < right.length && x > 2 * right[j]) j++;
            count += j;
        }
        const merged = [];
        let i = 0; j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) merged.push(left[i++]);
            else merged.push(right[j++]);
        }
        while (i < left.length) merged.push(left[i++]);
        while (j < right.length) merged.push(right[j++]);
        return [merged, count];
    };
    return mergeSort(nums)[1];
};
