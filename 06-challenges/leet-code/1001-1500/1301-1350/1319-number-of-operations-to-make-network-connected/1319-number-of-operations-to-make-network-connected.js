// https://leetcode.com/problems/number-of-operations-to-make-network-connected/

var makeConnected = function(n, connections) {
    if (connections.length < n-1) return -1;
    const parent = Array.from({length:n},(_,i)=>i);
    const find = x => parent[x]===x ? x : (parent[x]=find(parent[x]));
    let components = n;
    for (const [a,b] of connections) {
        const pa=find(a), pb=find(b);
        if (pa!==pb) { parent[pa]=pb; components--; }
    }
    return components-1;
};
