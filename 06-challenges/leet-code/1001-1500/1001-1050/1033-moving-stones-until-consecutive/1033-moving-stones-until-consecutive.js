// https://leetcode.com/problems/moving-stones-until-consecutive/

var numMovesStones = function(a, b, c) {
    const [x, y, z] = [a, b, c].sort((p, q) => p - q);
    const mx = (y - x - 1) + (z - y - 1);
    let mn;
    if (z - x === 2) mn = 0;
    else if (y - x <= 2 || z - y <= 2) mn = 1;
    else mn = 2;
    return [mn, mx];
};
