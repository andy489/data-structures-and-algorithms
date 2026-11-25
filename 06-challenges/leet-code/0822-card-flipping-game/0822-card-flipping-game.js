// https://leetcode.com/problems/card-flipping-game/

var flipgame = function(fronts, backs) {
    const same = new Set(fronts.filter((f, i) => f === backs[i]));
    let min = Infinity;
    for (let i = 0; i < fronts.length; i++) {
        if (!same.has(fronts[i])) { min = Math.min(min, fronts[i]); }
        if (!same.has(backs[i])) { min = Math.min(min, backs[i]); }
    }
    return min === Infinity ? 0 : min;
};
