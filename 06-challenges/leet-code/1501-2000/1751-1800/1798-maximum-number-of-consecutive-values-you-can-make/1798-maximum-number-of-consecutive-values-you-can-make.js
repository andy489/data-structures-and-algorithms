// https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/

var getMaximumConsecutive = function(coins) {
    coins.sort((a, b) => a - b);
    let reach = 0;
    for (const c of coins) {
        if (c > reach + 1) {
            break;
        }
        reach += c;
    }
    return reach + 1;
};
