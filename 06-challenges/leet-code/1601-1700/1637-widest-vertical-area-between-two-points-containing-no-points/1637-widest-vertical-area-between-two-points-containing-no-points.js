// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

var maxWidthOfVerticalArea = function(points) {
    const xs = points.map(p => p[0]).sort((a, b) => a - b);
    let max = 0;
    for (let i = 1; i < xs.length; i++) {
        max = Math.max(max, xs[i] - xs[i - 1]);
    }
    return max;
};
