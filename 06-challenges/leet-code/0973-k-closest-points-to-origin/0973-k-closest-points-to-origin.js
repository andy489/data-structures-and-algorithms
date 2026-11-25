// https://leetcode.com/problems/k-closest-points-to-origin/

var kClosest = function(points, k) {
    return points.sort((a, b) => (a[0]**2 + a[1]**2) - (b[0]**2 + b[1]**2)).slice(0, k);
};
