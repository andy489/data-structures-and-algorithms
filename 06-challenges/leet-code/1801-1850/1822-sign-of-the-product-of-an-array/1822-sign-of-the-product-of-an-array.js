// https://leetcode.com/problems/sign-of-the-product-of-an-array/

var arraySign = function(nums) {
    let sign = 1;
    for (const x of nums) {
        if (x === 0) return 0;
        if (x < 0) sign = -sign;
    }
    return sign;
};
