// https://leetcode.com/problems/stone-game-vi/

var stoneGameVI = function(aliceValues, bobValues) {
    const n = aliceValues.length;
    const combined = aliceValues.map((a, i) => [a + bobValues[i], a, bobValues[i]]);
    combined.sort((x, y) => y[0] - x[0]);
    let aliceScore = 0, bobScore = 0;
    for (let t = 0; t < n; t++) {
        if (t % 2 === 0) {
            aliceScore += combined[t][1];
        } else {
            bobScore += combined[t][2];
        }
    }
    if (aliceScore > bobScore) {
        return 1;
    }
    if (aliceScore < bobScore) {
        return -1;
    }
    return 0;
};
