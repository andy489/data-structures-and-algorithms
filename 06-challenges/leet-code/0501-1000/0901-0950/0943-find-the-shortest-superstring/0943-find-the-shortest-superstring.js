// https://leetcode.com/problems/find-the-shortest-superstring/

var shortestSuperstring = function(words) {
    const n = words.length;
    const overlap = Array.from({length:n}, () => new Array(n).fill(0));
    for (let i = 0; i < n; i++) for (let j = 0; j < n; j++) if (i!==j) {
        const maxOv = Math.min(words[i].length, words[j].length);
        for (let ov = maxOv; ov > 0; ov--) {
            if (words[i].endsWith(words[j].slice(0,ov))) { overlap[i][j]=ov; break; }
        }
    }
    const INF = Infinity;
    const dp = Array.from({length:1<<n},()=>new Array(n).fill(INF));
    const par = Array.from({length:1<<n},()=>new Array(n).fill(-1));
    for (let i=0;i<n;i++) dp[1<<i][i] = words[i].length;
    for (let mask=1;mask<1<<n;mask++) for (let last=0;last<n;last++) {
        if (!(mask>>last&1)||dp[mask][last]===INF) continue;
        for (let nxt=0;nxt<n;nxt++) {
            if (mask>>nxt&1) continue;
            const nm = mask|(1<<nxt), nl = dp[mask][last]+words[nxt].length-overlap[last][nxt];
            if (nl < dp[nm][nxt]) { dp[nm][nxt]=nl; par[nm][nxt]=last; }
        }
    }
    const full = (1<<n)-1;
    let last = 0; for (let i=1;i<n;i++) if (dp[full][i]<dp[full][last]) last=i;
    const order=[]; let mask=full;
    for (let i=0;i<n;i++) { order.push(last); const p=par[mask][last]; mask^=1<<last; last=p; }
    order.reverse();
    let res = words[order[0]];
    for (let i=1;i<n;i++) res += words[order[i]].slice(overlap[order[i-1]][order[i]]);
    return res;
};
