// https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/

var numTimesAllBlue = function(flips) {
    let maxF=0, cnt=0;
    for(let i=0;i<flips.length;i++){maxF=Math.max(maxF,flips[i]);if(maxF===i+1)cnt++;}
    return cnt;
};
