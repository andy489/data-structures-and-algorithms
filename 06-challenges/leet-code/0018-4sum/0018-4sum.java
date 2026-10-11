// https://leetcode.com/problems/4sum/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        final int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int l = j + 1;
                int r = n - 1;

                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum < target) {
                        ++l;
                    } else if (sum > target) {
                        --r;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                        while (l + 1 < r && nums[l] == nums[l + 1]) {
                            ++l;
                        }

                        while (l < r - 1 && nums[r - 1] == nums[r]) {
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
}
