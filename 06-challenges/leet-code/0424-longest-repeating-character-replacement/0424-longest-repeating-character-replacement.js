// https://leetcode.com/problems/longest-repeating-character-replacement/

var characterReplacement = function(s, k) {
    const charFreq = new Array(26).fill(0);
    let left = 0;
    let maxFreq = 0;

    for (let right = 0; right < s.length; right++) {
        const idx = s.charCodeAt(right) - 65;
        charFreq[idx]++;
        maxFreq = Math.max(maxFreq, charFreq[idx]);
        if ((right - left + 1) - maxFreq > k) {
            charFreq[s.charCodeAt(left) - 65]--;
            left++;
        }
    }
    return s.length - left;
};
