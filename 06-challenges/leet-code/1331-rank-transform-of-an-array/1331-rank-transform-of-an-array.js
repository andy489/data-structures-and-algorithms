// https://leetcode.com/problems/rank-transform-of-an-array/

var arrayRankTransform = function(arr) {
    const sorted = [...new Set(arr)].sort((a,b)=>a-b);
    const ranks = new Map(sorted.map((v,i)=>[v,i+1]));
    return arr.map(v=>ranks.get(v));
};
