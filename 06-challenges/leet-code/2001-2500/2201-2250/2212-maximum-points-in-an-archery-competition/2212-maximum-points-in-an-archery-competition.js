// https://leetcode.com/problems/maximum-points-in-an-archery-competition/
var maximumBobPoints = function(numArrows, aliceArrows) {
    let bestMask = 0;
    let bestScore = 0;
    for (let mask = 0; mask < (1 << 11); mask++) {
        let score = 0;
        let arrows = 0;
        for (let k = 1; k <= 11; k++) {
            if (mask & (1 << k)) {
                score += k;
                arrows += aliceArrows[k] + 1;
            }
        }
        if (arrows <= numArrows && score > bestScore) {
            bestScore = score;
            bestMask = mask;
        }
    }
    const bob = new Array(12).fill(0);
    let used = 0;
    for (let k = 1; k <= 11; k++) {
        if (bestMask & (1 << k)) {
            bob[k] = aliceArrows[k] + 1;
            used += bob[k];
        }
    }
    bob[0] = numArrows - used;
    return bob;
};
