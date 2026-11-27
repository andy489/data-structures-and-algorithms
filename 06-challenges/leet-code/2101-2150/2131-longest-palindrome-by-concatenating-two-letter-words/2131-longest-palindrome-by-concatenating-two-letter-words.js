// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
var longestPalindrome = function(words) {
    const freq = new Map();
    for (const w of words) {
        freq.set(w, (freq.get(w) || 0) + 1);
    }
    let length = 0;
    let centerUsed = false;
    for (const [w, cnt] of freq) {
        const rev = w[1] + w[0];
        if (w === rev) {
            length += Math.floor(cnt / 2) * 4;
            if (cnt % 2 === 1 && !centerUsed) {
                length += 2;
                centerUsed = true;
            }
        } else if (w < rev) {
            const pairs = Math.min(cnt, freq.get(rev) || 0);
            length += pairs * 4;
        }
    }
    return length;
};
