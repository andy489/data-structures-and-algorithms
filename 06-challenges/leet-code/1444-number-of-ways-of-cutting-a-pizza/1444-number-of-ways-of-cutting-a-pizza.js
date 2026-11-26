// https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/

var ways = function(pizza, k) {
    const MOD = 1000000007n, R = pizza.length, C = pizza[0].length;
    const suf = Array.from({length:R+1},()=>new Array(C+1).fill(0));
    for (let r = R-1; r >= 0; r--)
        for (let c = C-1; c >= 0; c--)
            suf[r][c] = (pizza[r][c]==='A'?1:0) + suf[r+1][c] + suf[r][c+1] - suf[r+1][c+1];
    const memo = new Map();
    function dp(r,c,p) {
        const key=`${r},${c},${p}`;
        if (memo.has(key)) return memo.get(key);
        if (p===1) { const v = suf[r][c]>0?1n:0n; memo.set(key,v); return v; }
        let res = 0n;
        for (let nr=r+1; nr<R; nr++) if (suf[r][c]-suf[nr][c]>0) res=(res+dp(nr,c,p-1))%MOD;
        for (let nc=c+1; nc<C; nc++) if (suf[r][c]-suf[r][nc]>0) res=(res+dp(r,nc,p-1))%MOD;
        memo.set(key,res); return res;
    }
    return Number(dp(0,0,k));
};
