// https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/

var countOfPairs = function(n, x, y) {
    const adj = Array.from({length:n+1}, ()=>[]);
    for (let i = 1; i < n; i++) { adj[i].push(i+1); adj[i+1].push(i); }
    if (x !== y) { adj[x].push(y); adj[y].push(x); }
    const answer = new Array(n).fill(0);
    for (let src = 1; src <= n; src++) {
        const dist = new Array(n+1).fill(-1);
        dist[src] = 0;
        const q = [src];
        for (let qi = 0; qi < q.length; qi++) {
            const u = q[qi];
            for (const v of adj[u]) { if (dist[v]===-1) { dist[v]=dist[u]+1; q.push(v); } }
        }
        for (let dst = 1; dst <= n; dst++) {
            if (dst !== src && dist[dst] >= 1 && dist[dst] <= n) answer[dist[dst]-1]++;
        }
    }
    return answer;
};
