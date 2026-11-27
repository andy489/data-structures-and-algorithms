// https://leetcode.com/problems/3sum/

var threeSum = function(nums) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    const res = [];

    for (let i = 0; i < n - 2; i++) {
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }
        if (nums[i] > 0) {
            break;
        }

        let l = i + 1;
        let r = n - 1;

        while (l < r) {
            const sum = nums[i] + nums[l] + nums[r];

            if (sum < 0) {
                l++;
            } else if (sum > 0) {
                r--;
            } else {
                res.push([nums[i], nums[l], nums[r]]);
                while (l < r && nums[l] === nums[l + 1]) {
                    l++;
                }
                while (l < r && nums[r] === nums[r - 1]) {
                    r--;
                }
                l++;
                r--;
            }
        }
    }

    return res;
};
