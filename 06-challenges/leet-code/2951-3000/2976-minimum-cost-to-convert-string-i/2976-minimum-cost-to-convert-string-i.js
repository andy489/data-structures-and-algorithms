// https://leetcode.com/problems/minimum-cost-to-convert-string-i/
var minimumCost = function(source, target, original, changed, cost) {
    const INF = Infinity;
    const dist = Array.from({length: 26}, (_, i) => {
        const row = new Array(26).fill(INF);
        row[i] = 0;
        return row;
    });
    for (let i = 0; i < original.length; i++) {
        const from = original[i].charCodeAt(0) - 97;
        const to = changed[i].charCodeAt(0) - 97;
        dist[from][to] = Math.min(dist[from][to], cost[i]);
    }
    for (let k = 0; k < 26; k++) {
        for (let i = 0; i < 26; i++) {
            for (let j = 0; j < 26; j++) {
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    let total = 0;
    for (let i = 0; i < source.length; i++) {
        const from = source.charCodeAt(i) - 97;
        const to = target.charCodeAt(i) - 97;
        if (dist[from][to] === INF) return -1;
        total += dist[from][to];
    }
    return total;
};
