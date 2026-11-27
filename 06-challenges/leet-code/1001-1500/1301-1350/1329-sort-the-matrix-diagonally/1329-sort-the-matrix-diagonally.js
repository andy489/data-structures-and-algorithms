// https://leetcode.com/problems/sort-the-matrix-diagonally/

var diagonalSort = function(mat) {
    const m=mat.length, n=mat[0].length, diags=new Map();
    for (let i=0;i<m;i++) for (let j=0;j<n;j++) {
        const k=i-j;
        if (!diags.has(k)) diags.set(k,[]);
        diags.get(k).push(mat[i][j]);
    }
    for (const v of diags.values()) v.sort((a,b)=>a-b);
    const idx=new Map();
    for (let i=0;i<m;i++) for (let j=0;j<n;j++) {
        const k=i-j, p=idx.get(k)||0;
        mat[i][j]=diags.get(k)[p];
        idx.set(k,p+1);
    }
    return mat;
};
