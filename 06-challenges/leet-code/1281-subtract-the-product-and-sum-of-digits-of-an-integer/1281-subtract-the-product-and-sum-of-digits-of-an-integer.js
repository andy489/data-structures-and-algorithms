// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

var subtractProductAndSum = function(n) {
    let product = 1, sum = 0;
    while (n > 0) { const d = n % 10; product *= d; sum += d; n = Math.floor(n / 10); }
    return product - sum;
};
