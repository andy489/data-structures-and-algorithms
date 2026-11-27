// https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i/

/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var numberOfSubstrings = function(s, k) {
    const n = s.length;
    let result = 0;
    const freq = new Array(26).fill(0);
    let left = 0;
    for (let right = 0; right < n; right++) {
        freq[s.charCodeAt(right) - 97]++;
        while (freq[s.charCodeAt(right) - 97] >= k) {
            result += n - right;
            freq[s.charCodeAt(left) - 97]--;
            left++;
        }
    }
    return result;
};
