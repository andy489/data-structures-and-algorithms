// https://leetcode.com/problems/valid-boomerang/

var isBoomerang = function(points) {
    const [x0,y0] = points[0], [x1,y1] = points[1], [x2,y2] = points[2];
    return (x1-x0)*(y2-y0) - (y1-y0)*(x2-x0) !== 0;
};
