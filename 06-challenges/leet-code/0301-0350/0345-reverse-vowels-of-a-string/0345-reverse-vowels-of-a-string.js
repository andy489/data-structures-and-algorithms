// https://leetcode.com/problems/reverse-vowels-of-a-string/

// Solution: Two Pointers — O(n) time, O(n) space
var reverseVowels = function(s) {
    const vowels = new Set('aeiouAEIOU');
    const chars = s.split('');
    let left = 0, right = chars.length - 1;
    while (left < right) {
        while (left < right && !vowels.has(chars[left])) left++;
        while (left < right && !vowels.has(chars[right])) right--;
        if (left < right) {
            [chars[left], chars[right]] = [chars[right], chars[left]];
            left++;
            right--;
        }
    }
    return chars.join('');
};
