// https://leetcode.com/problems/maximum-spending-after-buying-items/

var maxSpending = function(values) {
    const all = values.flat().sort((a, b) => a - b);
    let result = 0n;
    for (let i = 0; i < all.length; i++) {
        result += BigInt(all[i]) * BigInt(i + 1);
    }
    return Number(result);
};
