// https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/

/**
 * @param {number} k
 * @return {character}
 */
var kthCharacter = function (k) {
    let count = 0;
    let n = k - 1;
    while (n > 0) {
        count += n & 1;
        n >>= 1;
    }
    return String.fromCharCode('a'.charCodeAt(0) + count);
};
