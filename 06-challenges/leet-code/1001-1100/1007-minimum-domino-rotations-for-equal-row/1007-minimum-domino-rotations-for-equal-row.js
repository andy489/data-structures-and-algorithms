// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

var minDominoRotations = function(tops, bottoms) {
    const check = v => {
        let rotTop = 0, rotBot = 0;
        for (let i = 0; i < tops.length; i++) {
            if (tops[i] !== v && bottoms[i] !== v) return Infinity;
            if (tops[i] !== v) rotTop++;
            if (bottoms[i] !== v) rotBot++;
        }
        return Math.min(rotTop, rotBot);
    };
    const ans = Math.min(check(tops[0]), check(bottoms[0]));
    return ans === Infinity ? -1 : ans;
};
