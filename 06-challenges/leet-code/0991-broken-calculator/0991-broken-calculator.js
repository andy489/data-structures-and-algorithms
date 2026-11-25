// https://leetcode.com/problems/broken-calculator/

var brokenCalc = function(startValue, target) {
    let ops = 0;
    while (target > startValue) {
        if (target % 2 === 1) target++;
        else target >>= 1;
        ops++;
    }
    return ops + startValue - target;
};
