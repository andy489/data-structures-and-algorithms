// https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/

var maximumLengthSubstring = function(s) {
    const freq = new Array(26).fill(0);
    let l = 0, maxLen = 0;
    for (let r = 0; r < s.length; r++) {
        freq[s.charCodeAt(r) - 97]++;
        while (freq[s.charCodeAt(r) - 97] > 2) {
            freq[s.charCodeAt(l) - 97]--;
            l++;
        }
        maxLen = Math.max(maxLen, r - l + 1);
    }
    return maxLen;
};
