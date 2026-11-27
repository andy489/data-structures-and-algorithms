// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/

var findTheLongestSubstring = function(s) {
    const vb={'a':0,'e':1,'i':2,'o':3,'u':4};
    const first=new Array(32).fill(null);
    first[0]=-1;
    let mask=0, ans=0;
    for(let i=0;i<s.length;i++){
        const b=vb[s[i]];
        if(b!==undefined) mask^=(1<<b);
        if(first[mask]===null) first[mask]=i;
        else ans=Math.max(ans,i-first[mask]);
    }
    return ans;
};
