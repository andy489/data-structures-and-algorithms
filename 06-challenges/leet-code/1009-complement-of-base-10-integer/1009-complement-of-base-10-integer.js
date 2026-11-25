// https://leetcode.com/problems/complement-of-base-10-integer/

var bitwiseComplement = function(n) {
    if (n === 0) return 1;
    let mask = 1;
    while (mask < n) mask = (mask << 1) | 1;
    return n ^ mask;
};
