// https://leetcode.com/problems/reformat-the-string/

var reformat = function(s) {
    const digits = [...s].filter(c => c >= '0' && c <= '9');
    const letters = [...s].filter(c => c < '0' || c > '9');
    if (Math.abs(digits.length - letters.length) > 1) return "";
    let [a, b] = digits.length >= letters.length ? [digits, letters] : [letters, digits];
    return a.map((c, i) => c + (i < b.length ? b[i] : '')).join('');
};
