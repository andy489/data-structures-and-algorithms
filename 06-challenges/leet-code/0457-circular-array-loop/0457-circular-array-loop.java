// https://leetcode.com/problems/circular-array-loop/

// Solution: Fast/Slow Pointers — O(n) time, O(1) space
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = next(nums, i);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow == next(nums, slow)) {
                        break; // cycle of length 1
                    }
                    return true;
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            // mark all nodes in this path as visited
            int j = i;
            while (nums[j] * nums[next(nums, j)] > 0) {
                int tmp = next(nums, j);
                nums[j] = 0;
                j = tmp;
            }
        }
        return false;
    }

    private int next(int[] nums, int i) {
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n;
    }
}
