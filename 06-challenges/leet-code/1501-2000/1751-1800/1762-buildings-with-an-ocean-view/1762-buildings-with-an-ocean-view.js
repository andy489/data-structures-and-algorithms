// https://leetcode.com/problems/buildings-with-an-ocean-view/

var findBuildings = function(heights) {
    const n = heights.length;
    const result = [];
    let maxRight = 0;
    for (let i = n - 1; i >= 0; i--) {
        if (heights[i] > maxRight) {
            result.push(i);
            maxRight = heights[i];
        }
    }
    return result.reverse();
};
