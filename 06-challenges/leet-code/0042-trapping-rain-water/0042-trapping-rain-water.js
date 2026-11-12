// https://leetcode.com/problems/trapping-rain-water/

var trap = function(height) {
    let l = 0, r = height.length - 1;
    let maxL = 0, maxR = 0, water = 0;
    while (l < r) {
        if (maxL <= maxR) {
            maxL = Math.max(maxL, height[l]);
            water += maxL - height[l];
            l++;
        } else {
            maxR = Math.max(maxR, height[r]);
            water += maxR - height[r];
            r--;
        }
    }
    return water;
};
