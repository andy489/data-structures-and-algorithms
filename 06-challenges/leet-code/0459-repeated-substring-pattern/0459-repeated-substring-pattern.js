// https://leetcode.com/problems/repeated-substring-pattern/

var repeatedSubstringPattern = function(s) {
    const doubled = s + s;
    return doubled.slice(1, doubled.length - 1).includes(s);
};
