// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/

var minimumLength = function(s) {
    let l = 0, r = s.length - 1;
    while (l < r && s[l] === s[r]) {
        const c = s[l];
        while (l <= r && s[l] === c) l++;
        while (r >= l && s[r] === c) r--;
    }
    return r - l + 1;
};
