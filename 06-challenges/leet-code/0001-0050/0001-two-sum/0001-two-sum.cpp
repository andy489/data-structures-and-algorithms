// https://leetcode.com/problems/two-sum/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> indices;
        
        const int SIZE = nums.size();
        for (int i = 0; i < SIZE; ++i) {
            if (indices.count(target - nums[i])) {
                return {indices[target - nums[i]], i};
            }
            
            indices[nums[i]] = i;
        }
        
        return {-1, -1};
    }
};
