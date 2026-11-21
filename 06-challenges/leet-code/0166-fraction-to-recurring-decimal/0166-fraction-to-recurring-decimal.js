// https://leetcode.com/problems/fraction-to-recurring-decimal/

// Long division with Map — O(d) time, O(d) space
var fractionToDecimal = function(numerator, denominator) {
    if (numerator === 0) return "0";
    const sign = (numerator < 0) ^ (denominator < 0) ? '-' : '';
    let num = BigInt(Math.abs(numerator)), den = BigInt(Math.abs(denominator));
    let intPart = num / den;
    let rem = num % den;
    if (rem === 0n) return sign + intPart.toString();
    const remIdx = new Map();
    const frac = [];
    while (rem !== 0n) {
        if (remIdx.has(rem)) {
            frac.splice(remIdx.get(rem), 0, '(');
            frac.push(')');
            break;
        }
        remIdx.set(rem, frac.length);
        rem *= 10n;
        frac.push((rem / den).toString());
        rem %= den;
    }
    return sign + intPart.toString() + '.' + frac.join('');
};
