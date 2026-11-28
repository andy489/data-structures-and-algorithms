// https://leetcode.com/problems/reverse-degree-of-a-string/

var reverseDegree = function(s) {
    let result = 0;
    for (let i = 0; i < s.length; i++) {
        const reverseVal = 26 - (s.charCodeAt(i) - 97);
        result += (i + 1) * reverseVal;
    }
    return result;
};
