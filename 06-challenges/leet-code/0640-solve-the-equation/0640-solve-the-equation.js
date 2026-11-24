// https://leetcode.com/problems/solve-the-equation/

var solveEquation = function(equation) {
    function parse(expr) {
        let xCoef = 0, constant = 0, sign = 1, num = "", i = 0;
        while (i < expr.length) {
            const c = expr[i];
            if (c === '+' || c === '-') {
                if (num) constant += sign * parseInt(num);
                sign = c === '+' ? 1 : -1;
                num = "";
            } else if (c === 'x') {
                xCoef += sign * (num ? parseInt(num) : 1);
                num = "";
            } else {
                num += c;
            }
            i++;
        }
        if (num) constant += sign * parseInt(num);
        return [xCoef, constant];
    }
    const eqIdx = equation.indexOf('=');
    const [lx, lc] = parse(equation.substring(0, eqIdx));
    const [rx, rc] = parse(equation.substring(eqIdx + 1));
    const xCoef = lx - rx;
    const constVal = rc - lc;
    if (xCoef === 0) return constVal === 0 ? "Infinite solutions" : "No solution";
    return "x=" + Math.trunc(constVal / xCoef);
};
