// https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
var convertTime = function (current, correct) {
    const toMinutes = t => parseInt(t.slice(0, 2)) * 60 + parseInt(t.slice(3));
    let diff = toMinutes(correct) - toMinutes(current);
    let ops = 0;
    for (const inc of [60, 15, 5, 1]) {
        ops += Math.floor(diff / inc);
        diff %= inc;
    }
    return ops;
};
