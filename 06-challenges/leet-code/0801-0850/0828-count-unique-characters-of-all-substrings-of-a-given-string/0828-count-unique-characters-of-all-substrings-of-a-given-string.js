// https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/

var uniqueLetterString = function(s) {
    const n = s.length;
    const last = Array.from({length: 26}, () => [-1, -1]);
    let total = 0;
    for (let i = 0; i < n; i++) {
        const c = s.charCodeAt(i) - 65;
        total += (i - last[c][1]) * (last[c][1] - last[c][0]);
        last[c][0] = last[c][1];
        last[c][1] = i;
    }
    for (let c = 0; c < 26; c++) {
        total += (n - last[c][1]) * (last[c][1] - last[c][0]);
    }
    return total;
};
