// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

var findMinArrowShots = function(points) {
    points.sort((a, b) => a[1] - b[1]);
    let arrows = 1;
    let arrowPos = points[0][1];
    for (let i = 1; i < points.length; i++) {
        if (points[i][0] > arrowPos) {
            arrows++;
            arrowPos = points[i][1];
        }
    }
    return arrows;
};
