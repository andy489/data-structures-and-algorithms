// https://leetcode.com/problems/palindrome-number/

var isPalindrome = function(x) {
    if (x < 0) {
        return false;
    }
    const s = String(x);
    let l = 0;
    let r = s.length - 1;
    while (l < r) {
        if (s[l] !== s[r]) {
            return false;
        }
        l++;
        r--;
    }
    return true;
};
