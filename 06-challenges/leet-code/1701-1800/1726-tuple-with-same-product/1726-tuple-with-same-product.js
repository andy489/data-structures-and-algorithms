// https://leetcode.com/problems/tuple-with-same-product/

var tupleSameProduct = function(nums) {
    const productCount = new Map();
    const n = nums.length;
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            const prod = nums[i] * nums[j];
            productCount.set(prod, (productCount.get(prod) || 0) + 1);
        }
    }
    let ans = 0;
    for (const c of productCount.values()) {
        ans += c * (c - 1) / 2 * 8;
    }
    return ans;
};
