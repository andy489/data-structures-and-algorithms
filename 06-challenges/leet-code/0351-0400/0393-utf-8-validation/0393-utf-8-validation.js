// https://leetcode.com/problems/utf-8-validation/

// Solution: Bit Masking — O(n) time, O(1) space
var validUtf8 = function(data) {
    let cont = 0;
    for (let b of data) {
        b &= 0xFF;
        if (cont > 0) {
            if ((b & 0xC0) !== 0x80) return false;
            cont--;
        } else if ((b & 0x80) === 0) {
            cont = 0;
        } else if ((b & 0xE0) === 0xC0) {
            cont = 1;
        } else if ((b & 0xF0) === 0xE0) {
            cont = 2;
        } else if ((b & 0xF8) === 0xF0) {
            cont = 3;
        } else {
            return false;
        }
    }
    return cont === 0;
};
