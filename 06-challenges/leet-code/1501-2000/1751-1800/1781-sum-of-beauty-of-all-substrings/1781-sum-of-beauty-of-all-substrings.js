// https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

var beautySum = function(s) {
    const n = s.length;
    let result = 0;
    for (let i = 0; i < n; i++) {
        const freq = new Array(26).fill(0);
        for (let j = i; j < n; j++) {
            freq[s.charCodeAt(j) - 97]++;
            let maxFreq = 0, minFreq = Infinity;
            for (const f of freq) {
                if (f > 0) {
                    maxFreq = Math.max(maxFreq, f);
                    minFreq = Math.min(minFreq, f);
                }
            }
            result += maxFreq - minFreq;
        }
    }
    return result;
};
