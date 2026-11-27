// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/

// Solution: String Replacement — O(d) time, O(d) space
var minMaxDifference = function(num) {
    const s = String(num);
    // Maximize: replace first non-9 digit with 9
    const toMax = s.split('').find(c => c !== '9');
    const maxVal = toMax ? parseInt(s.split(toMax).join('9')) : num;
    // Minimize: replace first digit with 0
    const minVal = parseInt(s.split(s[0]).join('0'));
    return maxVal - minVal;
};
