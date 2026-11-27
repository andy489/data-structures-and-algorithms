// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

var maxScore = function(cardPoints, k) {
    const n = cardPoints.length, total = cardPoints.reduce((s,x) => s+x, 0), w = n - k;
    if (!w) return total;
    let window = cardPoints.slice(0, w).reduce((s,x) => s+x, 0), minW = window;
    for (let i = w; i < n; i++) {
        window += cardPoints[i] - cardPoints[i - w];
        minW = Math.min(minW, window);
    }
    return total - minW;
};
