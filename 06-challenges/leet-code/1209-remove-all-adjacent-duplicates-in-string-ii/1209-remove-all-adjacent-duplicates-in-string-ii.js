// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

var removeDuplicates = function(s, k) {
    const stack = [];
    for (const c of s) {
        if (stack.length && stack[stack.length-1][0] === c) {
            stack[stack.length-1][1]++;
            if (stack[stack.length-1][1] === k) stack.pop();
        } else {
            stack.push([c, 1]);
        }
    }
    return stack.map(([c, cnt]) => c.repeat(cnt)).join('');
};
