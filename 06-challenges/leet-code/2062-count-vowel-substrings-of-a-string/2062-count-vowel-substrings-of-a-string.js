// https://leetcode.com/problems/count-vowel-substrings-of-a-string/

// Solution: Brute Force — O(n^3) time, O(1) space
var countVowelSubstrings = function(word) {
    const vowels = new Set('aeiou');
    let count = 0;
    for (let i = 0; i < word.length; i++) {
        const seen = new Set();
        for (let j = i; j < word.length; j++) {
            if (!vowels.has(word[j])) break;
            seen.add(word[j]);
            if (seen.size === 5) count++;
        }
    }
    return count;
};
