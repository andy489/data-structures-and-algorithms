// https://leetcode.com/problems/remove-adjacent-almost-equal-characters/
var removeAlmostEqualCharacters = function(word) {
    let ops = 0;
    let i = 1;
    while (i < word.length) {
        if (Math.abs(word.charCodeAt(i) - word.charCodeAt(i - 1)) <= 1) {
            ops++;
            i += 2;
        } else {
            i++;
        }
    }
    return ops;
};
