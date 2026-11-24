// https://leetcode.com/problems/palindromic-substrings/

var countSubstrings = function(s) {
    function expand(left, right) {
        let count = 0;
        while (left >= 0 && right < s.length && s[left] === s[right]) {
            count++;
            left--;
            right++;
        }
        return count;
    }
    let total = 0;
    for (let i = 0; i < s.length; i++) {
        total += expand(i, i) + expand(i, i + 1);
    }
    return total;
};
