// https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/

var isPossibleToRearrange = function(s, t, k) {
    const n = s.length;
    const len = n / k;
    const freq = new Map();
    for (let i = 0; i < k; i++) {
        const chunk = s.substring(i * len, (i + 1) * len);
        freq.set(chunk, (freq.get(chunk) || 0) + 1);
    }
    for (let i = 0; i < k; i++) {
        const chunk = t.substring(i * len, (i + 1) * len);
        const cnt = (freq.get(chunk) || 0) - 1;
        if (cnt < 0) {
            return false;
        }
        freq.set(chunk, cnt);
    }
    return true;
};
