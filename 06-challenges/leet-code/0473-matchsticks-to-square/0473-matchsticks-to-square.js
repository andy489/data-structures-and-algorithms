// https://leetcode.com/problems/matchsticks-to-square/

var makesquare = function(matchsticks) {
    const total = matchsticks.reduce((a, b) => a + b, 0);
    if (total % 4 !== 0) return false;
    const target = total / 4;
    matchsticks.sort((a, b) => b - a);
    if (matchsticks[0] > target) return false;
    const sides = [0, 0, 0, 0];

    const backtrack = (idx) => {
        if (idx === matchsticks.length) {
            return sides[0] === target && sides[1] === target && sides[2] === target;
        }
        const stick = matchsticks[idx];
        const seen = new Set();
        for (let i = 0; i < 4; i++) {
            if (seen.has(sides[i])) continue;
            if (sides[i] + stick <= target) {
                seen.add(sides[i]);
                sides[i] += stick;
                if (backtrack(idx + 1)) return true;
                sides[i] -= stick;
            }
        }
        return false;
    };

    return backtrack(0);
};
