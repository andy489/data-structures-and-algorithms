// https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/

var countGoodRectangles = function(rectangles) {
    let maxLen = 0, count = 0;
    for (const [l, w] of rectangles) {
        const side = Math.min(l, w);
        if (side > maxLen) {
            maxLen = side;
            count = 1;
        } else if (side === maxLen) {
            count++;
        }
    }
    return count;
};
