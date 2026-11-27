// https://leetcode.com/problems/find-the-degree-of-each-vertex/
/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var findDegree = function(matrix) {
    return matrix.map(row => row.reduce((sum, val) => sum + val, 0));
};
