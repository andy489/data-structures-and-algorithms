// https://leetcode.com/problems/cheapest-flights-within-k-stops/

var findCheapestPrice = function(n, flights, src, dst, k) {
    let dist = new Array(n).fill(Infinity);
    dist[src] = 0;
    for (let i = 0; i <= k; i++) {
        const temp = [...dist];
        for (const [u, v, w] of flights) {
            if (dist[u] !== Infinity && dist[u] + w < temp[v]) {
                temp[v] = dist[u] + w;
            }
        }
        dist = temp;
    }
    return dist[dst] === Infinity ? -1 : dist[dst];
};
