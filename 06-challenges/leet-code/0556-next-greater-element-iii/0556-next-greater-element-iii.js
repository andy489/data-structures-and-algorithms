// https://leetcode.com/problems/next-greater-element-iii/
// Solution: Next permutation on digits — O(d) time, O(d) space
var nextGreaterElement = function(n) {
    const digits = n.toString().split('');
    const len = digits.length;
    let i = len - 2;
    while (i >= 0 && digits[i] >= digits[i + 1]) {
        i--;
    }
    if (i < 0) {
        return -1;
    }
    let j = len - 1;
    while (digits[j] <= digits[i]) {
        j--;
    }
    [digits[i], digits[j]] = [digits[j], digits[i]];
    const suffix = digits.splice(i + 1).reverse();
    digits.push(...suffix);
    const result = parseInt(digits.join(''), 10);
    return result > 2147483647 ? -1 : result;
};
