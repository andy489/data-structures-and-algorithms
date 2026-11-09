// https://leetcode.com/problems/next-permutation/

// Solution: Find Pivot + Swap + Reverse — O(n) time, O(1) space
const Solution = {
    nextPermutation(nums) {
        const n = nums.length;
        let i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            let j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            [nums[i], nums[j]] = [nums[j], nums[i]];
        }

        this._reverse(nums, i + 1, n - 1);
    },

    prevPermutation(nums) {
        const n = nums.length;
        let i = n - 2;

        while (i >= 0 && nums[i] <= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            let j = n - 1;
            while (nums[j] >= nums[i]) {
                j--;
            }
            [nums[i], nums[j]] = [nums[j], nums[i]];
        }

        this._reverse(nums, i + 1, n - 1);
    },

    _reverse(nums, lo, hi) {
        while (lo < hi) {
            [nums[lo], nums[hi]] = [nums[hi], nums[lo]];
            lo++;
            hi--;
        }
    }
};
