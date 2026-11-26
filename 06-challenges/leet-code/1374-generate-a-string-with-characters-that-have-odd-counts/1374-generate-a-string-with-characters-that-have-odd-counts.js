// https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/

var generateTheString = function(n) {
    return n%2 ? 'a'.repeat(n) : 'a'.repeat(n-1)+'b';
};
