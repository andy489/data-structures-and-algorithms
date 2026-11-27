// https://leetcode.com/problems/consecutive-characters/

var maxPower = function(s) {
    let max = 1, cur = 1;
    for (let i = 1; i < s.length; i++) {
        if (s[i] === s[i-1]) max = Math.max(max, ++cur);
        else cur = 1;
    }
    return max;
};
