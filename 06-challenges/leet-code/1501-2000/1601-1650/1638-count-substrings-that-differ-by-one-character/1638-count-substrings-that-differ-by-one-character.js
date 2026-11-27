// https://leetcode.com/problems/count-substrings-that-differ-by-one-character/

var countSubstrings = function(s, t) {
    const m = s.length, n = t.length;
    let ans = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (s[i] !== t[j]) {
                let left = 0;
                while (i - left - 1 >= 0 && j - left - 1 >= 0 && s[i - left - 1] === t[j - left - 1]) {
                    left++;
                }
                let right = 0;
                while (i + right + 1 < m && j + right + 1 < n && s[i + right + 1] === t[j + right + 1]) {
                    right++;
                }
                ans += (left + 1) * (right + 1);
            }
        }
    }
    return ans;
};
