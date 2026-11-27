// https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
var isPrefixString = function(s, words) {
    let built = '';
    for (const word of words) {
        built += word;
        if (built === s) {
            return true;
        }
        if (built.length > s.length) {
            return false;
        }
    }
    return false;
};
