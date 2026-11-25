// https://leetcode.com/problems/next-greater-node-in-linked-list/

var nextLargerNodes = function(head) {
    const vals = [];
    for (let cur = head; cur; cur = cur.next) vals.push(cur.val);
    const ans = new Array(vals.length).fill(0);
    const stack = [];
    for (let i = 0; i < vals.length; i++) {
        while (stack.length && vals[stack[stack.length-1]] < vals[i]) ans[stack.pop()] = vals[i];
        stack.push(i);
    }
    return ans;
};
