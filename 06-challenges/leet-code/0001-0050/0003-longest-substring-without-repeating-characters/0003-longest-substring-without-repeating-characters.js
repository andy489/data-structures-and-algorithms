// https://leetcode.com/problems/longest-substring-without-repeating-characters/

var lengthOfLongestSubstring = function(s) {
    const lastSeen = new Map();
    let lo = 0;
    let maxLen = 0;

    for (let hi = 0; hi < s.length; hi++) {
        const c = s[hi];
        if (lastSeen.has(c) && lastSeen.get(c) >= lo) {
            lo = lastSeen.get(c) + 1;
        }
        lastSeen.set(c, hi);
        maxLen = Math.max(maxLen, hi - lo + 1);
    }

    return maxLen;
};
