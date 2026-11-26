// https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

var maxFreq = function(s, maxLetters, minSize, maxSize) {
    const freq=new Map(); let res=0;
    for(let i=0;i<=s.length-minSize;i++){
        const sub=s.slice(i,i+minSize);
        if(new Set(sub).size<=maxLetters){
            freq.set(sub,(freq.get(sub)||0)+1);
            res=Math.max(res,freq.get(sub));
        }
    }
    return res;
};
