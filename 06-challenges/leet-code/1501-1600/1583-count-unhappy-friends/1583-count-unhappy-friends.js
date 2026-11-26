// https://leetcode.com/problems/count-unhappy-friends/

var unhappyFriends = function(n, preferences, pairs) {
    const rank = Array.from({length: n}, () => new Array(n).fill(0));
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n - 1; j++) {
            rank[i][preferences[i][j]] = j;
        }
    }
    const paired = new Array(n);
    for (const [x, y] of pairs) {
        paired[x] = y;
        paired[y] = x;
    }
    let count = 0;
    for (let x = 0; x < n; x++) {
        const y = paired[x];
        for (let u = 0; u < n; u++) {
            if (u === x || u === y) continue;
            const v = paired[u];
            if (rank[x][u] < rank[x][y] && rank[u][x] < rank[u][v]) {
                count++;
                break;
            }
        }
    }
    return count;
};
