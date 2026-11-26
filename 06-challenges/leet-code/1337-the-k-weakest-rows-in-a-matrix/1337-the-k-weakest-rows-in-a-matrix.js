// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

var kWeakestRows = function(mat, k) {
    return mat.map((row,i)=>[row.reduce((a,b)=>a+b,0),i])
        .sort((a,b)=>a[0]!==b[0]?a[0]-b[0]:a[1]-b[1])
        .slice(0,k).map(r=>r[1]);
};
