// https://leetcode.com/problems/minimum-levels-to-gain-more-points/

var minimumLevels = function(possible) {
    const scores = possible.map(x => x ? 1 : -1);
    const total = scores.reduce((a,b) => a+b, 0);
    let prefix = 0;
    for (let k = 0; k < possible.length - 1; k++) {
        prefix += scores[k];
        if (2 * prefix > total) return k + 1;
    }
    return -1;
};
