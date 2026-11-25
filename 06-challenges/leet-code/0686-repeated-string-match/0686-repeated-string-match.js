// https://leetcode.com/problems/repeated-string-match/

var repeatedStringMatch = function(a, b) {
    const count = Math.ceil(b.length / a.length);
    const repeated = a.repeat(count);
    if (repeated.includes(b)) return count;
    if ((repeated + a).includes(b)) return count + 1;
    return -1;
};
