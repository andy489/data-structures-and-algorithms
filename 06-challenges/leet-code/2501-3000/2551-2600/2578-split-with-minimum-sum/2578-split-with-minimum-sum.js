// https://leetcode.com/problems/split-with-minimum-sum/

/**
 * @param {number} num
 * @return {number}
 */
var splitNum = function(num) {
    const digits = String(num).split('').sort();
    let num1 = 0, num2 = 0;
    for (let i = 0; i < digits.length; i++) {
        if (i % 2 === 0) {
            num1 = num1 * 10 + parseInt(digits[i]);
        } else {
            num2 = num2 * 10 + parseInt(digits[i]);
        }
    }
    return num1 + num2;
};
