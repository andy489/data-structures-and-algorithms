// https://leetcode.com/problems/harshad-number/

var sumOfTheDigitsOfHarshadNumber = function(x) {
    const s = String(x).split('').reduce((a,d) => a + parseInt(d), 0);
    return x % s === 0 ? s : -1;
};
