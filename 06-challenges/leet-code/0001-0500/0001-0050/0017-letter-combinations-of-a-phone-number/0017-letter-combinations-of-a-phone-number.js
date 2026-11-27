// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

var letterCombinations = function(digits) {
    if (digits.length === 0) {
        return [];
    }

    const pad = ['abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz'];
    const res = [];

    function backtrack(i, current) {
        if (i === digits.length) {
            res.push(current);
            return;
        }
        for (const c of pad[digits.charCodeAt(i) - 50]) {
            backtrack(i + 1, current + c);
        }
    }

    backtrack(0, '');
    return res;
};
