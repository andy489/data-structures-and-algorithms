// https://leetcode.com/problems/trapping-rain-water/

var trap = function(height) {
    let l = 0, r = height.length - 1;
    let maxL = 0, maxR = 0, water = 0;
    while (l <= r) {
        if (maxL <= maxR) {
            water += Math.max(0, maxL - height[l]);
            maxL = Math.max(maxL, height[l]);
            l++;
        } else {
            water += Math.max(0, maxR - height[r]);
            maxR = Math.max(maxR, height[r]);
            r--;
        }
    }
    return water;
};
