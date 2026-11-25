// https://leetcode.com/problems/reverse-only-letters/

var reverseOnlyLetters = function(s) {
    const chars = s.split('');
    let left = 0, right = chars.length - 1;
    while (left < right) {
        while (left < right && !/[a-zA-Z]/.test(chars[left])) left++;
        while (left < right && !/[a-zA-Z]/.test(chars[right])) right--;
        if (left < right) {
            [chars[left], chars[right]] = [chars[right], chars[left]];
            left++; right--;
        }
    }
    return chars.join('');
};
