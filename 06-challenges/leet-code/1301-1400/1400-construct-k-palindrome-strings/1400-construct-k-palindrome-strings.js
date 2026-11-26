// https://leetcode.com/problems/construct-k-palindrome-strings/

var canConstruct = function(s, k) {
    if(k>s.length) return false;
    const cnt=new Array(26).fill(0);
    for(const c of s) cnt[c.charCodeAt(0)-97]++;
    return cnt.filter(v=>v%2).length<=k;
};
