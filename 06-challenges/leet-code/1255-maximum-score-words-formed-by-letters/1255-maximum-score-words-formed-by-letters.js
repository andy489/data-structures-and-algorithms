// https://leetcode.com/problems/maximum-score-words-formed-by-letters/

var maxScoreWords = function(words, letters, score) {
    const avail=new Array(26).fill(0);for(const c of letters)avail[c.charCodeAt(0)-97]++;
    const n=words.length;let res=0;
    for(let mask=0;mask<(1<<n);mask++){
        const need=new Array(26).fill(0);let s=0,ok=true;
        for(let i=0;i<n;i++) if(mask>>i&1) for(const c of words[i]){need[c.charCodeAt(0)-97]++;s+=score[c.charCodeAt(0)-97];}
        for(let i=0;i<26;i++) if(need[i]>avail[i]){ok=false;break;}
        if(ok)res=Math.max(res,s);
    }
    return res;
};
