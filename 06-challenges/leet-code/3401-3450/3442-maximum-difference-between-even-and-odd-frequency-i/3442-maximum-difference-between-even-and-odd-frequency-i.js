// https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/
var maxDifference = function(s) {
    const freq = {};
    for (const c of s) {
        freq[c] = (freq[c] || 0) + 1;
    }
    let maxOdd = -Infinity, minEven = Infinity;
    for (const f of Object.values(freq)) {
        if (f % 2 === 1) {
            maxOdd = Math.max(maxOdd, f);
        } else {
            minEven = Math.min(minEven, f);
        }
    }
    return maxOdd - minEven;
};
