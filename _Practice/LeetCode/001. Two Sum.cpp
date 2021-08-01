// https://leetcode.com/problems/two-sum/
// Time: O(n) in expectation

class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        vector<int> res(2);
        unordered_map<int, int> lookUp;
        int SIZE = nums.size();
        for (int i = 0; i < SIZE; ++i) {
            int complement = target - nums[i];
            if (lookUp.count(complement)) {
                res[0] = i, res[1] = lookUp[complement];
                break;
            } else {
                lookUp.insert({nums[i], i});
            }
        }
        return res;
    }
};
