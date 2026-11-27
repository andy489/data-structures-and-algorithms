// https://leetcode.com/problems/string-to-integer-atoi/

var myAtoi = function(s) {
    const MAX = 2147483647;
    const MIN = -2147483648;
    let i = 0;
    const n = s.length;

    while (i < n && s[i] === ' ') {
        i++;
    }

    if (i === n) {
        return 0;
    }

    let sign = 1;
    if (s[i] === '+') {
        i++;
    } else if (s[i] === '-') {
        sign = -1;
        i++;
    }

    let res = 0;
    while (i < n && s[i] >= '0' && s[i] <= '9') {
        res = res * 10 + (s.charCodeAt(i) - 48);
        if (sign * res > MAX) {
            return MAX;
        }
        if (sign * res < MIN) {
            return MIN;
        }
        i++;
    }

    return sign * res;
};
