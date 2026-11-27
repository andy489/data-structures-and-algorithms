/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function (s1, s2) {
    if (s1.length > s2.length) {
        return false;
    }
    const freq = new Array(26).fill(0);
    const window = new Array(26).fill(0);
    const a = 'a'.charCodeAt(0);
    for (const c of s1) {
        freq[c.charCodeAt(0) - a]++;
    }
    for (let i = 0; i < s2.length; i++) {
        window[s2.charCodeAt(i) - a]++;
        if (i >= s1.length) {
            window[s2.charCodeAt(i - s1.length) - a]--;
        }
        if (freq.every((v, idx) => v === window[idx])) {
            return true;
        }
    }
    return false;
};
