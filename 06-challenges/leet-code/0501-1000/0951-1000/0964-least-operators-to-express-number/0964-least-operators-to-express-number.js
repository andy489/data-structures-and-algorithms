// https://leetcode.com/problems/least-operators-to-express-number/

var leastOpsExpressTarget = function(x, target) {
    let pos = 0, neg = 0, k = 0;
    while (target > 0) {
        const d = target % x;
        target = Math.floor(target / x);
        if (k === 0) {
            pos = d * 2;
            neg = (x - d) * 2;
        } else {
            [pos, neg] = [
                Math.min(pos + d * 2 * k, neg + (d + 1) * 2 * k),
                Math.min(pos + (x - d) * 2 * k, neg + (x - d - 1) * 2 * k)
            ];
        }
        k++;
    }
    return Math.min(pos, neg + 2 * k) - 1;
};
