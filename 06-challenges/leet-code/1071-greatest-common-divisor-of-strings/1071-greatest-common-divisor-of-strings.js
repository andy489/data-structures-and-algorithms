// https://leetcode.com/problems/greatest-common-divisor-of-strings/

var gcdOfStrings = function(str1, str2) {
    if (str1 + str2 !== str2 + str1) return "";
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    return str1.slice(0, gcd(str1.length, str2.length));
};
