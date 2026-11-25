// https://leetcode.com/problems/sort-an-array/

var sortArray = function(nums) {
    const merge = (a, b) => {
        const result = [];
        let i = 0, j = 0;
        while (i < a.length && j < b.length) {
            result.push(a[i] <= b[j] ? a[i++] : b[j++]);
        }
        return result.concat(a.slice(i)).concat(b.slice(j));
    };
    const mergeSort = arr => {
        if (arr.length <= 1) return arr;
        const mid = arr.length >> 1;
        return merge(mergeSort(arr.slice(0, mid)), mergeSort(arr.slice(mid)));
    };
    return mergeSort(nums);
};
