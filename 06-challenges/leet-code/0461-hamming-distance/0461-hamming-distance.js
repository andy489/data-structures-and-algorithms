// https://leetcode.com/problems/hamming-distance/

var hammingDistance = function(x, y) {
    let xor = x ^ y;
    let dist = 0;
    while (xor) {
        dist += xor & 1;
        xor >>>= 1;
    }
    return dist;
};
