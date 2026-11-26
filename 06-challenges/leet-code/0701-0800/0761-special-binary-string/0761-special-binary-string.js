// https://leetcode.com/problems/special-binary-string/

var makeLargestSpecial = function(s) {
    const parts = [];
    let count = 0, start = 0;
    for (let i = 0; i < s.length; i++) {
        count += s[i] === '1' ? 1 : -1;
        if (count === 0) {
            parts.push('1' + makeLargestSpecial(s.slice(start + 1, i)) + '0');
            start = i + 1;
        }
    }
    return parts.sort().reverse().join('');
};
