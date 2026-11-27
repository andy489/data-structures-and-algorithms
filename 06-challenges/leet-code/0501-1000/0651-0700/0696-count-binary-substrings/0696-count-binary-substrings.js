// https://leetcode.com/problems/count-binary-substrings/

var countBinarySubstrings = function(s) {
    let result = 0, prev = 0, curr = 1;
    for (let i = 1; i < s.length; i++) {
        if (s[i] === s[i - 1]) {
            curr++;
        } else {
            result += Math.min(prev, curr);
            prev = curr;
            curr = 1;
        }
    }
    return result + Math.min(prev, curr);
};
