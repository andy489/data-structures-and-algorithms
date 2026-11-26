// https://leetcode.com/problems/remove-duplicate-letters/

var removeDuplicateLetters = function(s) {
    const last = {};
    for (let i = 0; i < s.length; i++) last[s[i]] = i;
    const stack = [], inStack = new Set();
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (inStack.has(c)) continue;
        while (stack.length && stack[stack.length-1] > c && last[stack[stack.length-1]] > i) {
            inStack.delete(stack.pop());
        }
        stack.push(c);
        inStack.add(c);
    }
    return stack.join('');
};
