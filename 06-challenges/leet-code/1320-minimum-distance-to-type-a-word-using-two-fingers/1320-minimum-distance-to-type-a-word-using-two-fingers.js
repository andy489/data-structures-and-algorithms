// https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/

var minimumDistance = function(word) {
    const dist = (a, b) => a === 26 ? 0 : Math.abs(~~(a/6)-~~(b/6))+Math.abs(a%6-b%6);
    const INF = Infinity;
    let dp = Array.from({length:27},()=>new Array(27).fill(INF));
    dp[26][26] = 0;
    for (const ch of word) {
        const c = ch.charCodeAt(0)-65;
        const nxt = Array.from({length:27},()=>new Array(27).fill(INF));
        for (let f1=0;f1<27;f1++) for (let f2=0;f2<27;f2++) {
            if (dp[f1][f2]===INF) continue;
            nxt[c][f2] = Math.min(nxt[c][f2], dp[f1][f2]+dist(f1,c));
            nxt[f1][c] = Math.min(nxt[f1][c], dp[f1][f2]+dist(f2,c));
        }
        dp = nxt;
    }
    return Math.min(...dp.flatMap(r=>r));
};
