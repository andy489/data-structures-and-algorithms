// https://leetcode.com/problems/powx-n/

var myPow = function(x, n) {
    if (n < 0) {
        x = 1.0 / x;
        n = -n;
    }
    let result = 1.0;
    while (n > 0) {
        if (n & 1) {
            result *= x;
        }
        x *= x;
        n >>>= 1;
    }
    return result;
};
