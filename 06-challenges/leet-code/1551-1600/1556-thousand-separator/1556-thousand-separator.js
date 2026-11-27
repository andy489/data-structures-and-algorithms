// https://leetcode.com/problems/thousand-separator/

var thousandSeparator = function(n) {
    const s = String(n);
    let result = '';
    for (let i = 0; i < s.length; i++) {
        const rem = s.length - i;
        if (i > 0 && rem % 3 === 0) {
            result += '.';
        }
        result += s[i];
    }
    return result;
};
