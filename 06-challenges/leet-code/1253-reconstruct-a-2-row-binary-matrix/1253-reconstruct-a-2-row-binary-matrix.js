// https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/

var reconstructMatrix = function(upper, lower, colsum) {
    const n=colsum.length,r0=new Array(n).fill(0),r1=new Array(n).fill(0);
    for(let i=0;i<n;i++){if(colsum[i]===2){r0[i]=r1[i]=1;upper--;lower--;}if(upper<0||lower<0)return[];}
    for(let i=0;i<n;i++){if(colsum[i]===1){if(upper>0){r0[i]=1;upper--;}else{r1[i]=1;lower--;}}}
    return upper===0&&lower===0?[r0,r1]:[];
};
