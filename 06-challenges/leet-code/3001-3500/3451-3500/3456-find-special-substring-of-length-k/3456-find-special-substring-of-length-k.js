// https://leetcode.com/problems/find-special-substring-of-length-k/

var hasSpecialSubstring = function(s, k) {
    const n = s.length;
    let i = 0;
    while (i < n) {
        const c = s[i];
        let j = i;
        while (j < n && s[j] === c) {
            j++;
        }
        const len = j - i;
        if (len === k) {
            const validBefore = (i === 0 || s[i - 1] !== c);
            const validAfter = (j === n || s[j] !== c);
            if (validBefore && validAfter) {
                return true;
            }
        }
        i = j;
    }
    return false;
};
