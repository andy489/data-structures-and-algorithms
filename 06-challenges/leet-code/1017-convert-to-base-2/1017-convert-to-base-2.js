// https://leetcode.com/problems/convert-to-base-2/

var baseNeg2 = function(n) {
    if (n === 0) return "0";
    const bits = [];
    while (n !== 0) {
        let rem = ((n % -2) + 2) % 2;
        n = Math.trunc((n - rem) / -2);
        bits.push(rem);
    }
    return bits.reverse().join('');
};
