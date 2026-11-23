// https://leetcode.com/problems/reverse-string/

// Solution: Two Pointers — O(n) time, O(1) space
var reverseString = function(s) {
    let left = 0, right = s.length - 1;
    while (left < right) {
        [s[left], s[right]] = [s[right], s[left]];
        left++;
        right--;
    }
};
