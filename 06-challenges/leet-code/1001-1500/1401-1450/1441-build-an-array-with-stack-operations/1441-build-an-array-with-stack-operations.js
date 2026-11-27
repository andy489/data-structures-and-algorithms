// https://leetcode.com/problems/build-an-array-with-stack-operations/

var buildArray = function(target, n) {
    const tSet = new Set(target);
    const ops = [];
    for (let i = 1; i <= target[target.length-1]; i++) {
        ops.push("Push");
        if (!tSet.has(i)) ops.push("Pop");
    }
    return ops;
};
