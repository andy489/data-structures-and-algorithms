// https://leetcode.com/problems/find-center-of-star-graph/

var findCenter = function(edges) {
    if (edges[0][0] === edges[1][0] || edges[0][0] === edges[1][1]) {
        return edges[0][0];
    }
    return edges[0][1];
};
