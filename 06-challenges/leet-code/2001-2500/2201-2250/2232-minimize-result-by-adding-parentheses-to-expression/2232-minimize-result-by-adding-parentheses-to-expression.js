// https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/

/**
 * @param {string} expression
 * @return {string}
 */
var minimizeResult = function(expression) {
    const plus = expression.indexOf('+');
    const n = expression.length;
    let best = Infinity, bestI = 0, bestJ = n - 1;

    for (let i = 0; i < plus; i++) {
        for (let j = plus + 1; j < n; j++) {
            const a = i === 0 ? 1 : parseInt(expression.slice(0, i));
            const b = parseInt(expression.slice(i, plus));
            const c = parseInt(expression.slice(plus + 1, j + 1));
            const d = j === n - 1 ? 1 : parseInt(expression.slice(j + 1));
            const val = a * (b + c) * d;
            if (val < best) {
                best = val;
                bestI = i;
                bestJ = j;
            }
        }
    }

    return expression.slice(0, bestI) + '(' + expression.slice(bestI, bestJ + 1) + ')' + expression.slice(bestJ + 1);
};
