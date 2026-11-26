// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

var numberOfSubstrings = function(s) {
    const last=[-1,-1,-1];
    let cnt=0;
    for(let i=0;i<s.length;i++){
        last[s.charCodeAt(i)-97]=i;
        cnt+=1+Math.min(...last);
    }
    return cnt;
};
