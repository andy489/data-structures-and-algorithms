// https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/
var minimumOperationsToMakeEqual = function(x, y) {
    if (x <= y) {
        return y - x;
    }
    const queue = [[x, 0]];
    const visited = new Set([x]);
    while (queue.length > 0) {
        const [val, dist] = queue.shift();
        if (val === y) {
            return dist;
        }
        const neighbors = [val - 1, val + 1];
        if (val % 5 === 0) {
            neighbors.push(val / 5);
        }
        if (val % 11 === 0) {
            neighbors.push(val / 11);
        }
        for (const nxt of neighbors) {
            if (nxt >= 1 && !visited.has(nxt) && nxt <= x + 11) {
                visited.add(nxt);
                queue.push([nxt, dist + 1]);
            }
        }
    }
    return -1;
};
