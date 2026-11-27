// https://leetcode.com/problems/container-with-most-water/

class Solution {
public:
    int maxArea(vector<int> &height) {
        int mxWater = 0;

        int l = 0;
        int r = height.size() - 1;

        while (l < r) {
            int h = min(height[l], height[r]);

            mxWater = max(mxWater, (r - l) * h);

            while (height[l] <= h && l < r) {
                ++l;
            }

            while (height[r] <= h && l < r) {
                --r;
            }
        }

        return mxWater;
    }
};
