// https://leetcode.com/problems/longest-happy-prefix/

var longestPrefix = function(s) {
    const n=s.length, kmp=new Array(n).fill(0);
    let j=0;
    for(let i=1;i<n;i++){
        while(j>0&&s[i]!==s[j]) j=kmp[j-1];
        if(s[i]===s[j]) j++;
        kmp[i]=j;
    }
    return s.slice(0,kmp[n-1]);
};
