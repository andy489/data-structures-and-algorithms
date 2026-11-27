// https://leetcode.com/problems/relative-sort-array/

var relativeSortArray = function(arr1, arr2) {
    const rank = new Map(arr2.map((v, i) => [v, i]));
    return arr1.sort((a, b) => {
        const ra = rank.has(a) ? rank.get(a) : arr2.length + a;
        const rb = rank.has(b) ? rank.get(b) : arr2.length + b;
        return ra - rb;
    });
};
