// https://leetcode.com/problems/complex-number-multiplication/

var complexNumberMultiply = function(num1, num2) {
    function parse(s) {
        const plusIdx = s.lastIndexOf('+');
        return [parseInt(s.slice(0, plusIdx), 10), parseInt(s.slice(plusIdx + 1, -1), 10)];
    }
    const [a, b] = parse(num1);
    const [c, d] = parse(num2);
    return `${a*c - b*d}+${a*d + b*c}i`;
};
