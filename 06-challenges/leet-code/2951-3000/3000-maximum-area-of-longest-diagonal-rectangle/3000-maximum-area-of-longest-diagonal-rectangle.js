// https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/

var maximumAreaOfLongestDiagonalRectangle = function(dimensions) {
    let maxDiag2 = 0, maxArea = 0;
    for (const [l, w] of dimensions) {
        const diag2 = l*l + w*w, area = l*w;
        if (diag2 > maxDiag2 || (diag2 === maxDiag2 && area > maxArea)) {
            maxDiag2 = diag2; maxArea = area;
        }
    }
    return maxArea;
};
