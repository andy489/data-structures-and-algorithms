// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/

var maxCoins = function(piles) {
    piles.sort((a, b) => a - b);
    const n = Math.floor(piles.length / 3);
    let sum = 0;
    for (let i = piles.length - 2; i >= n; i -= 2) {
        sum += piles[i];
    }
    return sum;
};
