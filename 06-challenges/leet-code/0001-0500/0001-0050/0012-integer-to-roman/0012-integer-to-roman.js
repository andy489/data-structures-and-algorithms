// https://leetcode.com/problems/integer-to-roman/

var intToRoman = function(num) {
    const romans = ['I', 'IV', 'V', 'IX', 'X', 'XL', 'L', 'XC', 'C', 'CD', 'D', 'CM', 'M'];
    const numerals = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000];
    let res = '';

    for (let i = 12; i >= 0; i--) {
        while (num >= numerals[i]) {
            res += romans[i];
            num -= numerals[i];
        }
    }

    return res;
};
