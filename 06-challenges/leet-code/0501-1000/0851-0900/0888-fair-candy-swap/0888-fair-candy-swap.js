// https://leetcode.com/problems/fair-candy-swap/

var fairCandySwap = function(aliceSizes, bobSizes) {
    const sumA = aliceSizes.reduce((s, x) => s + x, 0);
    const sumB = bobSizes.reduce((s, x) => s + x, 0);
    const delta = (sumB - sumA) / 2;
    const bobSet = new Set(bobSizes);
    for (const a of aliceSizes) {
        if (bobSet.has(a + delta)) return [a, a + delta];
    }
};
