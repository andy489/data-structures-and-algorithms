// https://leetcode.com/problems/base-7/

var convertToBase7 = function(num) {
    if (num === 0) return "0";
    const negative = num < 0;
    num = Math.abs(num);
    let result = "";
    while (num > 0) {
        result = (num % 7) + result;
        num = Math.floor(num / 7);
    }
    return negative ? "-" + result : result;
};
