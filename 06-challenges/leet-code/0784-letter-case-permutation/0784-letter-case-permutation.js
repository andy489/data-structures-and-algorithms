// https://leetcode.com/problems/letter-case-permutation/

var letterCasePermutation = function(s) {
    const result = [];
    function backtrack(i, path) {
        if (i === s.length) {
            result.push(path.join(''));
            return;
        }
        path.push(s[i]);
        backtrack(i + 1, path);
        if (s[i].match(/[a-zA-Z]/)) {
            path[path.length - 1] = s[i] === s[i].toLowerCase() ? s[i].toUpperCase() : s[i].toLowerCase();
            backtrack(i + 1, path);
        }
        path.pop();
    }
    backtrack(0, []);
    return result;
};
