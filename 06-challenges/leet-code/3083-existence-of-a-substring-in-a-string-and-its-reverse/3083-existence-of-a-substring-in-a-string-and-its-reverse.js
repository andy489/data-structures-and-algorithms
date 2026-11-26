// https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/

var isSubstringPresent = function(s) {
    const pairs = new Set();
    for (let i = 0; i+1 < s.length; i++) pairs.add(s[i]+s[i+1]);
    for (let i = 0; i+1 < s.length; i++) if (pairs.has(s[i+1]+s[i])) return true;
    return false;
};
