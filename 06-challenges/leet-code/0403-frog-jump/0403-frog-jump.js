// https://leetcode.com/problems/frog-jump/

var canCross = function(stones) {
    const reachable = new Map();
    for (const stone of stones) {
        reachable.set(stone, new Set());
    }
    reachable.get(0).add(0);
    for (const stone of stones) {
        for (const k of reachable.get(stone)) {
            for (const delta of [-1, 0, 1]) {
                const nextJump = k + delta;
                if (nextJump > 0 && reachable.has(stone + nextJump)) {
                    reachable.get(stone + nextJump).add(nextJump);
                }
            }
        }
    }
    return reachable.get(stones[stones.length - 1]).size > 0;
};
