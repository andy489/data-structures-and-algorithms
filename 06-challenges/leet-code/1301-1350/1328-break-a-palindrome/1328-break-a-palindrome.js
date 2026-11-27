// https://leetcode.com/problems/break-a-palindrome/

var breakPalindrome = function(palindrome) {
    const n = palindrome.length;
    if (n === 1) return "";
    const s = [...palindrome];
    for (let i = 0; i < Math.floor(n/2); i++) {
        if (s[i] !== 'a') { s[i] = 'a'; return s.join(''); }
    }
    s[n-1] = 'b';
    return s.join('');
};
