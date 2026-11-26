// https://leetcode.com/problems/maximal-network-rank/

var maximalNetworkRank = function(n, roads) {
    const degree = new Array(n).fill(0);
    const connected = Array.from({length: n}, () => new Array(n).fill(false));
    for (const [a, b] of roads) {
        degree[a]++;
        degree[b]++;
        connected[a][b] = connected[b][a] = true;
    }
    let maxRank = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            const rank = degree[i] + degree[j] - (connected[i][j] ? 1 : 0);
            maxRank = Math.max(maxRank, rank);
        }
    }
    return maxRank;
};
