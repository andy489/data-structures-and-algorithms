// https://leetcode.com/problems/valid-palindrome/

// Solution 1: Two Pointers (In-Place)
var isPalindrome = function(s) {
    let left = 0, right = s.length - 1;
    while (left < right) {
        while (left < right && !isAlnum(s[left])) left++;
        while (left < right && !isAlnum(s[right])) right--;
        if (s[left].toLowerCase() !== s[right].toLowerCase()) return false;
        left++;
        right--;
    }
    return true;
};

function isAlnum(c) {
    return /[a-zA-Z0-9]/.test(c);
}

// Solution 2: Clean then Check
var isPalindrome2 = function(s) {
    const cleaned = s.toLowerCase().replace(/[^a-z0-9]/g, '');
    return cleaned === cleaned.split('').reverse().join('');
};
