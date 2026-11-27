// https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/

var countPoints = function(points, queries) {
    return queries.map(([cx, cy, r]) =>
        points.filter(([px, py]) => (px - cx) ** 2 + (py - cy) ** 2 <= r * r).length
    );
};
