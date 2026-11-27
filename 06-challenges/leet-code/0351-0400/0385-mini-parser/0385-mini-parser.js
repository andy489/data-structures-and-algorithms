// https://leetcode.com/problems/mini-parser/

// Solution: Stack — O(n) time, O(n) space
var deserialize = function(s) {
    if (!s.startsWith('[')) return new NestedInteger(parseInt(s));
    const stack = [];
    let start = 0;
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (c === '[') {
            stack.push(new NestedInteger());
            start = i + 1;
        } else if (c === ']' || c === ',') {
            if (i > start) stack[stack.length - 1].add(new NestedInteger(parseInt(s.slice(start, i))));
            start = i + 1;
            if (c === ']' && stack.length > 1) {
                const top = stack.pop();
                stack[stack.length - 1].add(top);
            }
        }
    }
    return stack[0];
};
