// https://leetcode.com/problems/find-all-good-strings/

var findGoodStrings = function(n, s1, s2, evil) {
    const MOD=1_000_000_007n, m=evil.length;
    const fail=new Array(m).fill(0);
    let j=0;
    for(let i=1;i<m;i++){
        while(j>0&&evil[i]!==evil[j]) j=fail[j-1];
        if(evil[i]===evil[j]) j++;
        fail[i]=j;
    }
    const memo=new Map();
    const dp=(pos,kmp,tl,tr)=>{
        if(kmp===m) return 0n;
        if(pos===n) return 1n;
        const key=`${pos},${kmp},${tl},${tr}`;
        if(memo.has(key)) return memo.get(key);
        const lo=tl?s1.charCodeAt(pos):97, hi=tr?s2.charCodeAt(pos):122;
        let res=0n;
        for(let c=lo;c<=hi;c++){
            let nk=kmp;
            while(nk>0&&evil.charCodeAt(nk)!==c) nk=fail[nk-1];
            if(evil.charCodeAt(nk)===c) nk++;
            if(nk===m) continue;
            res=(res+dp(pos+1,nk,tl&&c===lo,tr&&c===hi))%MOD;
        }
        memo.set(key,res);
        return res;
    };
    return Number(dp(0,0,true,true));
};
