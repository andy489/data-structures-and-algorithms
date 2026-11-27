// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/

var minInsertions = function(s) {
    let insertions = 0, open = 0, i = 0;
    while (i < s.length) {
        if (s[i] === '(') {
            open++;
            i++;
        } else {
            if (i + 1 < s.length && s[i + 1] === ')') {
                i += 2;
            } else {
                insertions++;
                i++;
            }
            if (open > 0) {
                open--;
            } else {
                insertions++;
            }
        }
    }
    return insertions + open * 2;
};
