// https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/

var kthSmallest = function(mat, k) {
    let cands = mat[0].slice().sort((a,b)=>a-b).slice(0,k);
    for (let r = 1; r < mat.length; r++) {
        const sums = [];
        for (const c of cands) for (const v of mat[r]) sums.push(c+v);
        sums.sort((a,b)=>a-b);
        cands = sums.slice(0,k);
    }
    return cands[k-1];
};
