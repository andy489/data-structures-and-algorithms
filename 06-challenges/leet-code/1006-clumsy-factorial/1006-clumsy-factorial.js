// https://leetcode.com/problems/clumsy-factorial/

var clumsy = function(n) {
    const stack = [n];
    n--;
    let op = 0;
    while (n > 0) {
        if (op === 0) stack[stack.length-1] *= n;
        else if (op === 1) stack[stack.length-1] = Math.trunc(stack[stack.length-1] / n);
        else if (op === 2) stack.push(n);
        else stack.push(-n);
        op = (op + 1) % 4;
        n--;
    }
    return stack.reduce((s, v) => s + v, 0);
};
