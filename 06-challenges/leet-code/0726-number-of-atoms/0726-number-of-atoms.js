// https://leetcode.com/problems/number-of-atoms/

var countOfAtoms = function(formula) {
    const stack = [new Map()];
    let i = 0;
    const n = formula.length;
    while (i < n) {
        const c = formula[i];
        if (c === '(') {
            stack.push(new Map());
            i++;
        } else if (c === ')') {
            i++;
            const start = i;
            while (i < n && formula[i] >= '0' && formula[i] <= '9') i++;
            const mult = i > start ? parseInt(formula.slice(start, i)) : 1;
            const top = stack.pop();
            const curr = stack[stack.length - 1];
            for (const [elem, cnt] of top) {
                curr.set(elem, (curr.get(elem) || 0) + cnt * mult);
            }
        } else if (formula[i] >= 'A' && formula[i] <= 'Z') {
            const start = i++;
            while (i < n && formula[i] >= 'a' && formula[i] <= 'z') i++;
            const elem = formula.slice(start, i);
            const numStart = i;
            while (i < n && formula[i] >= '0' && formula[i] <= '9') i++;
            const count = i > numStart ? parseInt(formula.slice(numStart, i)) : 1;
            const curr = stack[stack.length - 1];
            curr.set(elem, (curr.get(elem) || 0) + count);
        }
    }
    const counts = stack[0];
    return [...counts.keys()].sort().map(elem => {
        const cnt = counts.get(elem);
        return elem + (cnt > 1 ? cnt : '');
    }).join('');
};
