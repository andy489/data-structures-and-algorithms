// https://leetcode.com/problems/lucky-numbers-in-a-matrix/

var luckyNumbers = function(matrix) {
    const m=matrix.length, n=matrix[0].length;
    const rowMin=matrix.map(r=>Math.min(...r));
    const colMax=Array.from({length:n},(_,j)=>Math.max(...matrix.map(r=>r[j])));
    const res=[];
    for(let i=0;i<m;i++) for(let j=0;j<n;j++) if(matrix[i][j]===rowMin[i]&&matrix[i][j]===colMax[j]) res.push(matrix[i][j]);
    return res;
};
