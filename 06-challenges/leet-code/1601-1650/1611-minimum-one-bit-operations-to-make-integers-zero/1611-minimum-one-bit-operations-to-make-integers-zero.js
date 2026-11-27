// https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/

var minimumOneBitOperations = function(n) {
    let result = 0;
    while (n > 0) {
        result ^= n;
        n >>= 1;
    }
    return result;
};
