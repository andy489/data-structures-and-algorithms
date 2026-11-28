// https://leetcode.com/problems/count-beautiful-substrings-i/

var beautifulSubstrings = function(s, k) {
    const vowelSet = new Set(['a','e','i','o','u']);
    const n = s.length;
    let count = 0;
    for (let i = 0; i < n; i++) {
        let vowels = 0;
        for (let j = i; j < n; j++) {
            if (vowelSet.has(s[j])) vowels++;
            const consonants = (j - i + 1) - vowels;
            if (vowels === consonants && (vowels * consonants) % k === 0) {
                count++;
            }
        }
    }
    return count;
};
