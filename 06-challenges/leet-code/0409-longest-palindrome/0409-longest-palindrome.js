// https://leetcode.com/problems/longest-palindrome/

var longestPalindrome = function(s) {
    const freq = {};
    for (const c of s) {
        freq[c] = (freq[c] || 0) + 1;
    }
    let length = 0;
    for (const count of Object.values(freq)) {
        length += Math.floor(count / 2) * 2;
    }
    return length < s.length ? length + 1 : length;
};
