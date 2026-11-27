// https://leetcode.com/problems/parsing-a-boolean-expression/

// Solution: Stack-Based Parsing — O(n) time, O(n) space
var parseBoolExpr = function(expression) {
    const stack = [];
    for (const c of expression) {
        if (c === ',') { continue; }
        if (c !== ')') {
            stack.push(c);
        } else {
            const vals = [];
            while (stack[stack.length - 1] !== '(') {
                vals.push(stack.pop());
            }
            stack.pop(); // remove '('
            const op = stack.pop();
            let result;
            if (op === '!') {
                result = vals[0] === 't' ? 'f' : 't';
            } else if (op === '&') {
                result = vals.includes('f') ? 'f' : 't';
            } else { // '|'
                result = vals.includes('t') ? 't' : 'f';
            }
            stack.push(result);
        }
    }
    return stack[stack.length - 1] === 't';
};
