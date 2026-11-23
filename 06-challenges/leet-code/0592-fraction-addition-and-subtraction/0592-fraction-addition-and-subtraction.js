// https://leetcode.com/problems/fraction-addition-and-subtraction/
var fractionAddition = function(expression) {
    const tokens = expression.match(/[+-]?\d+\/\d+/g);
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    let numerator = 0, denominator = 1;
    for (const token of tokens) {
        const slash = token.indexOf('/');
        const num = parseInt(token.slice(0, slash));
        const den = parseInt(token.slice(slash + 1));
        numerator = numerator * den + num * denominator;
        denominator *= den;
        const g = gcd(Math.abs(numerator), denominator);
        numerator = Math.trunc(numerator / g);
        denominator = Math.trunc(denominator / g);
    }
    return `${numerator}/${denominator}`;
};
