// https://leetcode.com/problems/number-complement/

var findComplement = function(num) {
    let mask = num;
    mask |= mask >> 1;
    mask |= mask >> 2;
    mask |= mask >> 4;
    mask |= mask >> 8;
    mask |= mask >> 16;
    return num ^ mask;
};
