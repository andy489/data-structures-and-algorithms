// https://leetcode.com/problems/4sum/

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());

        const int n = nums.size();
        vector<vector<int>> res;

        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int l = j + 1, r = n - 1;

                while (l < r) {
                    long long sum = (long long)nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum < target) {
                        ++l;
                    } else if (sum > target) {
                        --r;
                    } else {
                        res.push_back({nums[i], nums[j], nums[l], nums[r]});

                        while (l + 1 < r && nums[l] == nums[l + 1]) {
                            ++l;
                        }

                        while (l < r - 1 && nums[r] == nums[r - 1]) {
                            --r;
                        }

                        ++l;
                        --r;
                    }
                }
            }
        }

        return res;
    }
};
