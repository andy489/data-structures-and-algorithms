// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/

var minFlips = function(a, b, c) {
    let flips = 0;
    while (a || b || c) {
        const [ba, bb, bc] = [a&1, b&1, c&1];
        flips += bc ? (ba===0&&bb===0 ? 1 : 0) : ba+bb;
        a>>=1; b>>=1; c>>=1;
    }
    return flips;
};
