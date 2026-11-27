// https://leetcode.com/problems/reformat-phone-number/

var reformatNumber = function(number) {
    const digits = number.replace(/[ -]/g, '');
    const result = [];
    let i = 0;
    while (digits.length - i > 4) {
        result.push(digits.slice(i, i + 3));
        i += 3;
    }
    if (digits.length - i === 4) {
        result.push(digits.slice(i, i + 2));
        result.push(digits.slice(i + 2, i + 4));
    } else {
        result.push(digits.slice(i));
    }
    return result.join('-');
};
