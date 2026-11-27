// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/

var mctFromLeafValues = function(arr) {
    const stack = [Infinity];
    let ans = 0;
    for (const v of arr) {
        while (stack[stack.length - 1] <= v) {
            const mid = stack.pop();
            ans += mid * Math.min(stack[stack.length - 1], v);
        }
        stack.push(v);
    }
    while (stack.length > 2) {
        const top = stack.pop();
        ans += top * stack[stack.length - 1];
    }
    return ans;
};
