// https://leetcode.com/problems/longest-chunked-palindrome-decomposition/

var longestDecomposition = function(text) {
    let ans = 0, l = 0, r = text.length - 1;
    while (l <= r) {
        let found = false;
        for (let len = 1; len <= Math.floor((r - l + 1) / 2); len++) {
            if (text.slice(l, l + len) === text.slice(r - len + 1, r + 1)) {
                ans += 2;
                l += len;
                r -= len;
                found = true;
                break;
            }
        }
        if (!found) {
            ans += 1;
            break;
        }
    }
    return ans;
};
