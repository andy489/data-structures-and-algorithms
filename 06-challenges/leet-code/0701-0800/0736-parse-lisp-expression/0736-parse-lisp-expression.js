// https://leetcode.com/problems/parse-lisp-expression/

var evaluate = function(expression) {
    let idx = 0;
    function parse(scope) {
        if (expression[idx] === '(') {
            idx++;
            let res;
            if (expression.startsWith('let', idx)) {
                idx += 3;
                const local = Object.assign({}, scope);
                while (true) {
                    idx++; // space
                    const c = expression[idx];
                    if (c === '(' || c === '-' || (c >= '0' && c <= '9')) {
                        res = parse(local); break;
                    }
                    let start = idx;
                    while (idx < expression.length && expression[idx] !== ' ' && expression[idx] !== ')') idx++;
                    const name = expression.slice(start, idx);
                    if (expression[idx] === ')') { res = local[name] ?? 0; break; }
                    idx++;
                    const val = parse(local);
                    local[name] = val;
                }
            } else if (expression.startsWith('add', idx)) {
                idx += 3; idx++;
                const a = parse(scope); idx++;
                const b = parse(scope);
                res = a + b;
            } else {
                idx += 4; idx++;
                const a = parse(scope); idx++;
                const b = parse(scope);
                res = a * b;
            }
            idx++; // ')'
            return res;
        } else if (expression[idx] === '-' || (expression[idx] >= '0' && expression[idx] <= '9')) {
            let start = idx;
            if (expression[idx] === '-') idx++;
            while (idx < expression.length && expression[idx] >= '0' && expression[idx] <= '9') idx++;
            return parseInt(expression.slice(start, idx));
        } else {
            let start = idx;
            while (idx < expression.length && expression[idx] !== ' ' && expression[idx] !== ')') idx++;
            return scope[expression.slice(start, idx)] ?? 0;
        }
    }
    return parse({});
};
