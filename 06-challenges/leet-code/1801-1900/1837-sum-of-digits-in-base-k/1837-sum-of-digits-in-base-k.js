// https://leetcode.com/problems/sum-of-digits-in-base-k/

var sumBase = function(n, k) {
    let sum = 0;
    while (n > 0) {
        sum += n % k;
        n = Math.floor(n / k);
    }
    return sum;
};
