// https://leetcode.com/problems/find-champion-ii/

var findChampion = function(n, edges) {
    const inDegree = new Array(n).fill(0);
    for (const [u, v] of edges) {
        inDegree[v]++;
    }
    let champion = -1;
    let count = 0;
    for (let i = 0; i < n; i++) {
        if (inDegree[i] === 0) {
            champion = i;
            count++;
        }
    }
    return count === 1 ? champion : -1;
};
