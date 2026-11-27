// https://leetcode.com/problems/maximum-swap/

var maximumSwap = function(num) {
    const digits = num.toString().split('');
    const last = {};
    for (let i = 0; i < digits.length; i++) last[digits[i]] = i;
    for (let i = 0; i < digits.length; i++) {
        for (let d = 9; d > parseInt(digits[i]); d--) {
            if ((last[d] || 0) > i) {
                const j = last[d];
                [digits[i], digits[j]] = [digits[j], digits[i]];
                return parseInt(digits.join(''));
            }
        }
    }
    return num;
};
