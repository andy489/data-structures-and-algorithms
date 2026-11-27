// https://leetcode.com/problems/longest-palindromic-substring/

var longestPalindrome = function(s) {
    let start = 0;
    let maxLen = 1;

    function expand(l, r) {
        while (l >= 0 && r < s.length && s[l] === s[r]) {
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                start = l;
            }
            l--;
            r++;
        }
    }

    for (let i = 0; i < s.length; i++) {
        expand(i, i);
        expand(i, i + 1);
    }

    return s.substring(start, start + maxLen);
};
