// https://leetcode.com/problems/sort-vowels-by-frequency/
/**
 * @param {string} s
 * @return {string}
 */
var sortVowelsByFrequency = function(s) {
    const vowels = new Set(['a','e','i','o','u']);
    const freq = {};
    const firstOcc = {};
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (vowels.has(c)) {
            freq[c] = (freq[c] || 0) + 1;
            if (!(c in firstOcc)) { firstOcc[c] = i; }
        }
    }
    const vowelPositions = [];
    const vowelChars = [];
    for (let i = 0; i < s.length; i++) {
        if (vowels.has(s[i])) {
            vowelPositions.push(i);
            vowelChars.push(s[i]);
        }
    }
    vowelChars.sort((a, b) => {
        if (freq[b] !== freq[a]) { return freq[b] - freq[a]; }
        return firstOcc[a] - firstOcc[b];
    });
    const res = s.split('');
    for (let i = 0; i < vowelPositions.length; i++) {
        res[vowelPositions[i]] = vowelChars[i];
    }
    return res.join('');
};
