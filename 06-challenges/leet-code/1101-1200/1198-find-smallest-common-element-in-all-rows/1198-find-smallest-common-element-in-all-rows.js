// https://leetcode.com/problems/find-smallest-common-element-in-all-rows/

var smallestCommonElement = function(mat) {
    const count = new Array(10001).fill(0);
    for (const row of mat) for (const v of row) count[v]++;
    const m = mat.length;
    for (const v of mat[0]) if (count[v] === m) return v;
    return -1;
};
