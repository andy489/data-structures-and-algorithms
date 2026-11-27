// https://leetcode.com/problems/custom-sort-string/

var customSortString = function(order, s) {
    const freq = new Array(26).fill(0);
    for (const c of s) freq[c.charCodeAt(0) - 97]++;
    let result = '';
    for (const c of order) {
        const i = c.charCodeAt(0) - 97;
        result += c.repeat(freq[i]);
        freq[i] = 0;
    }
    for (let i = 0; i < 26; i++) {
        result += String.fromCharCode(97 + i).repeat(freq[i]);
    }
    return result;
};
