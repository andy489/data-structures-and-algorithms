// https://leetcode.com/problems/increasing-decreasing-string/

var sortString = function(s) {
    const cnt=new Array(26).fill(0);
    for(const c of s) cnt[c.charCodeAt(0)-97]++;
    const res=[];
    while(res.length<s.length){
        for(let i=0;i<26;i++) if(cnt[i]>0){res.push(String.fromCharCode(97+i));cnt[i]--;}
        for(let i=25;i>=0;i--) if(cnt[i]>0){res.push(String.fromCharCode(97+i));cnt[i]--;}
    }
    return res.join('');
};
