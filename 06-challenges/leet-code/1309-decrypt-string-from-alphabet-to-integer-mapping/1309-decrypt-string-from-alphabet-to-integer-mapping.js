// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/

var freqAlphabets = function(s) {
    const res = [];
    let i = s.length - 1;
    while (i >= 0) {
        if (s[i] === '#') {
            res.push(String.fromCharCode('a'.charCodeAt(0) + parseInt(s.slice(i-2,i)) - 1));
            i -= 3;
        } else {
            res.push(String.fromCharCode('a'.charCodeAt(0) + parseInt(s[i]) - 1));
            i--;
        }
    }
    return res.reverse().join('');
};
