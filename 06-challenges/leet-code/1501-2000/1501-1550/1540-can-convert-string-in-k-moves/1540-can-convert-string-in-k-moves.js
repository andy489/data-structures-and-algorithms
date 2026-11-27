// https://leetcode.com/problems/can-convert-string-in-k-moves/

var canConvertString = function(s, t, k) {
    if (s.length !== t.length) return false;
    const count = new Array(26).fill(0);
    for (let i = 0; i < s.length; i++) {
        const diff = (t.charCodeAt(i) - s.charCodeAt(i) + 26) % 26;
        if (diff !== 0) {
            count[diff]++;
            if (count[diff] * 26 - 26 + diff > k) return false;
        }
    }
    return true;
};
