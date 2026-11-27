// https://leetcode.com/problems/reverse-integer/

var reverse = function(x) {
    const MAX = 2147483647;
    const MIN = -2147483648;
    let res = 0;

    while (x !== 0) {
        res = res * 10 + (x % 10);
        x = Math.trunc(x / 10);
    }

    if (res > MAX || res < MIN) {
        return 0;
    }

    return res;
};
