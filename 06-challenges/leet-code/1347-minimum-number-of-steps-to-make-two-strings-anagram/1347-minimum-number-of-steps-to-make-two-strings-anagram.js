// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

var minSteps = function(s, t) {
    const cnt=new Array(26).fill(0);
    for(const c of s) cnt[c.charCodeAt(0)-97]++;
    for(const c of t) cnt[c.charCodeAt(0)-97]--;
    return cnt.reduce((a,v)=>a+(v>0?v:0),0);
};
