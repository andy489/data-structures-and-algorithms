// https://leetcode.com/problems/replace-the-substring-for-balanced-string/

var balancedString = function(s) {
    const n=s.length,k=n>>2,cnt={Q:0,W:0,E:0,R:'QWER'.includes};
    const c={Q:0,W:0,E:0,R:0};for(const ch of s)c[ch]++;
    if(c.Q===k&&c.W===k&&c.E===k&&c.R===k)return 0;
    let res=n,l=0;
    for(let r=0;r<n;r++){
        c[s[r]]--;
        while(l<=r&&c.Q<=k&&c.W<=k&&c.E<=k&&c.R<=k){res=Math.min(res,r-l+1);c[s[l++]]++;}
    }
    return res;
};
