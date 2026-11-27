// https://leetcode.com/problems/sort-colors/

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int lo = 0, mid = 0, hi = (int)nums.size() - 1;

        while (mid <= hi) {
            if (nums[mid] == 0) {
                swap(nums[lo++], nums[mid++]);
            } else if (nums[mid] == 1) {
                ++mid;
            } else {
                swap(nums[mid], nums[hi--]);
            }
        }
    }
};
