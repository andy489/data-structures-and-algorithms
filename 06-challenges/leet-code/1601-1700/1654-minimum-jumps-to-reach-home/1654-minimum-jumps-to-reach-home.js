// https://leetcode.com/problems/minimum-jumps-to-reach-home/

var minimumJumps = function(forbidden, a, b, x) {
    const forbidSet = new Set(forbidden);
    let limit = x + a + b;
    for (const f of forbidden) {
        limit = Math.max(limit, f + a + b);
    }
    // visited[pos][0=forward, 1=backward]
    const visited = Array.from({length: limit + 1}, () => [false, false]);
    const queue = [[0, 0]];
    visited[0][0] = true;
    let steps = 0;
    while (queue.length > 0) {
        const size = queue.length;
        for (let i = 0; i < size; i++) {
            const [pos, back] = queue[i];
            if (pos === x) {
                return steps;
            }
            const fwd = pos + a;
            if (fwd <= limit && !forbidSet.has(fwd) && !visited[fwd][0]) {
                visited[fwd][0] = true;
                queue.push([fwd, 0]);
            }
            if (!back) {
                const bwd = pos - b;
                if (bwd > 0 && !forbidSet.has(bwd) && !visited[bwd][1]) {
                    visited[bwd][1] = true;
                    queue.push([bwd, 1]);
                }
            }
        }
        queue.splice(0, size);
        steps++;
    }
    return -1;
};
