// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

var minOperations = function(boxes) {
    const n = boxes.length;
    const ans = new Array(n).fill(0);
    let balls = 0, ops = 0;
    for (let i = 0; i < n; i++) {
        ans[i] += ops;
        balls += Number(boxes[i]);
        ops += balls;
    }
    balls = ops = 0;
    for (let i = n - 1; i >= 0; i--) {
        ans[i] += ops;
        balls += Number(boxes[i]);
        ops += balls;
    }
    return ans;
};
