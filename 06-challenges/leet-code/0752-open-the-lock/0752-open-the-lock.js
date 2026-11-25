// https://leetcode.com/problems/open-the-lock/

var openLock = function(deadends, target) {
    const dead = new Set(deadends);
    if (dead.has('0000')) return -1;
    if (target === '0000') return 0;
    const visited = new Set(['0000']);
    const queue = [['0000', 0]];
    while (queue.length) {
        const [state, steps] = queue.shift();
        for (let i = 0; i < 4; i++) {
            for (const delta of [1, -1]) {
                const nxt = state.slice(0, i) + ((+state[i] + delta + 10) % 10) + state.slice(i + 1);
                if (nxt === target) return steps + 1;
                if (!visited.has(nxt) && !dead.has(nxt)) {
                    visited.add(nxt); queue.push([nxt, steps + 1]);
                }
            }
        }
    }
    return -1;
};
