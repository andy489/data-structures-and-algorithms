// https://leetcode.com/problems/mirror-frequency-distance/
/**
 * @param {string} s
 * @return {number}
 */
var mirrorFrequencyDistance = function(s) {
    const freq = new Array(128).fill(0);
    for (const c of s) {
        freq[c.charCodeAt(0)]++;
    }

    let result = 0;

    // Letter pairs: (a,z), (b,y), ..., (m,n) — 13 pairs
    for (let i = 0; i < 13; i++) {
        const c = 'a'.charCodeAt(0) + i;
        const m = 'z'.charCodeAt(0) - i;
        result += Math.abs(freq[c] - freq[m]);
    }

    // Digit pairs: (0,9), (1,8), ..., (4,5) — 5 pairs
    for (let i = 0; i < 5; i++) {
        const c = '0'.charCodeAt(0) + i;
        const m = '9'.charCodeAt(0) - i;
        result += Math.abs(freq[c] - freq[m]);
    }

    return result;
};
