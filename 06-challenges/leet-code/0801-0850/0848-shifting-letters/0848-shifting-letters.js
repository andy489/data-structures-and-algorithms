// https://leetcode.com/problems/shifting-letters/

var shiftingLetters = function(s, shifts) {
    const chars = s.split('');
    let total = 0;
    for (let i = s.length - 1; i >= 0; i--) {
        total = (total + shifts[i]) % 26;
        chars[i] = String.fromCharCode((chars[i].charCodeAt(0) - 97 + total) % 26 + 97);
    }
    return chars.join('');
};
