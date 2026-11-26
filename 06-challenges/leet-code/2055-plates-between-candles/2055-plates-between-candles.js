// https://leetcode.com/problems/plates-between-candles/

// Solution: Prefix Sums + Binary Search — O((n+q) log n) time, O(n) space
var platesBetweenCandles = function(s, queries) {
    const n = s.length;
    const prefix = new Array(n+1).fill(0);
    const candles = [];
    for (let i = 0; i < n; i++) {
        prefix[i+1] = prefix[i] + (s[i] === '*' ? 1 : 0);
        if (s[i] === '|') candles.push(i);
    }
    const bsl = (v) => { let lo=0,hi=candles.length; while(lo<hi){const m=(lo+hi)>>1; candles[m]<v?lo=m+1:hi=m;} return lo; };
    const bsr = (v) => { let lo=0,hi=candles.length; while(lo<hi){const m=(lo+hi)>>1; candles[m]<=v?lo=m+1:hi=m;} return lo; };
    return queries.map(([l, r]) => {
        const cl = bsl(l), cr = bsr(r) - 1;
        return cl <= cr ? prefix[candles[cr]+1] - prefix[candles[cl]] : 0;
    });
};
