// https://leetcode.com/problems/find-palindrome-with-fixed-length/
var kthPalindrome = function (queries, intLength) {
    const halfLen = Math.floor((intLength + 1) / 2);
    const start = Math.pow(10, halfLen - 1);
    const end = Math.pow(10, halfLen);
    return queries.map(q => {
        const half = start + q - 1;
        if (half >= end) {
            return -1;
        }
        const halfStr = String(half);
        const skip = intLength % 2 === 1 ? 1 : 0;
        const mirror = halfStr.slice(0, halfStr.length - skip).split('').reverse().join('');
        return parseInt(halfStr + mirror);
    });
};
