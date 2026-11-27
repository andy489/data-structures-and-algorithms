// https://leetcode.com/problems/largest-substring-between-two-equal-characters/

var maxLengthBetweenEqualCharacters = function(s) {
    const first = {};
    let ans = -1;
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (!(c in first)) {
            first[c] = i;
        } else {
            ans = Math.max(ans, i - first[c] - 1);
        }
    }
    return ans;
};
