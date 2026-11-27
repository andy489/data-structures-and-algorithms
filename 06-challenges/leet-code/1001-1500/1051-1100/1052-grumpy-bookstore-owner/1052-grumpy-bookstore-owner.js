// https://leetcode.com/problems/grumpy-bookstore-owner/

var maxSatisfied = function(customers, grumpy, minutes) {
    let base = 0;
    for (let i = 0; i < customers.length; i++) if (!grumpy[i]) base += customers[i];
    let extra = 0;
    for (let i = 0; i < minutes; i++) extra += customers[i] * grumpy[i];
    let maxExtra = extra;
    for (let i = minutes; i < customers.length; i++) {
        extra += customers[i]*grumpy[i] - customers[i-minutes]*grumpy[i-minutes];
        maxExtra = Math.max(maxExtra, extra);
    }
    return base + maxExtra;
};
