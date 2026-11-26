// https://leetcode.com/problems/calculate-money-in-leetcode-bank/

var totalMoney = function(n) {
    const weeks = Math.floor(n / 7);
    const days = n % 7;
    const fullWeeks = 7 * weeks * (weeks - 1) / 2 + 28 * weeks;
    const partial = days * (weeks + 1) + days * (days - 1) / 2;
    return fullWeeks + partial;
};
