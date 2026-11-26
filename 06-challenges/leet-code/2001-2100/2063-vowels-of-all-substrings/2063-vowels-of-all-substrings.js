// https://leetcode.com/problems/vowels-of-all-substrings/

// Solution: Contribution Count — O(n) time, O(1) space
var countVowels = function(word) {
    const n = word.length, vowels = new Set('aeiou');
    let res = 0;
    for (let i = 0; i < n; i++) { if (vowels.has(word[i])) res += (i + 1) * (n - i); }
    return res;
};
