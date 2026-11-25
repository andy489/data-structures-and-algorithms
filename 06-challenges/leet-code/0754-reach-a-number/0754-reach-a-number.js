// https://leetcode.com/problems/reach-a-number/

var reachNumber = function(target) {
    target = Math.abs(target);
    let sum = 0, k = 0;
    while (sum < target || (sum - target) % 2 !== 0) {
        k++;
        sum += k;
    }
    return k;
};
