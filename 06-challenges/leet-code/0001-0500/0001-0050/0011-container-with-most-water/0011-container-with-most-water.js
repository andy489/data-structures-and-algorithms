// https://leetcode.com/problems/container-with-most-water/

var maxArea = function(height) {
    let maxWater = 0;
    let l = 0;
    let r = height.length - 1;

    while (l < r) {
        const h = Math.min(height[l], height[r]);
        maxWater = Math.max(maxWater, (r - l) * h);
        while (height[l] <= h && l < r) {
            l++;
        }
        while (height[r] <= h && l < r) {
            r--;
        }
    }

    return maxWater;
};
