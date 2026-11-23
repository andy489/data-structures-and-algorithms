// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

// Solution: Divide and Conquer — O(n * 26) time, O(26 * log n) space
var longestSubstring = function(s, k) {
    function solve(l, r) {
        if (r - l + 1 < k) return 0;
        const freq = new Array(26).fill(0);
        for (let i = l; i <= r; i++) freq[s.charCodeAt(i) - 97]++;
        for (let i = l; i <= r; i++) {
            if (freq[s.charCodeAt(i) - 97] < k) {
                return Math.max(solve(l, i - 1), solve(i + 1, r));
            }
        }
        return r - l + 1;
    }
    return solve(0, s.length - 1);
};
