// https://leetcode.com/problems/min-cost-to-connect-all-points/

var minCostConnectPoints = function(points) {
    const n = points.length;
    const minDist = new Array(n).fill(Infinity);
    const inMST = new Array(n).fill(false);
    minDist[0] = 0;
    let totalCost = 0;
    for (let iter = 0; iter < n; iter++) {
        let u = -1;
        for (let i = 0; i < n; i++) {
            if (!inMST[i] && (u === -1 || minDist[i] < minDist[u])) u = i;
        }
        inMST[u] = true;
        totalCost += minDist[u];
        for (let v = 0; v < n; v++) {
            if (!inMST[v]) {
                const dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                minDist[v] = Math.min(minDist[v], dist);
            }
        }
    }
    return totalCost;
};
