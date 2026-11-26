// https://leetcode.com/problems/1-bit-and-2-bit-characters/

var isOneBitCharacter = function(bits) {
    let i = 0;
    while (i < bits.length - 1) {
        i += bits[i] === 1 ? 2 : 1;
    }
    return i === bits.length - 1;
};
