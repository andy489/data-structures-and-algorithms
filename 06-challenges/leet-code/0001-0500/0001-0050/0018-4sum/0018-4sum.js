// https://leetcode.com/problems/4sum/

var fourSum = function(nums, target) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    const res = [];

    for (let i = 0; i < n - 3; i++) {
        if (i > 0 && nums[i] === nums[i - 1]) {
            continue;
        }

        for (let j = i + 1; j < n - 2; j++) {
            if (j > i + 1 && nums[j] === nums[j - 1]) {
                continue;
            }

            let l = j + 1;
            let r = n - 1;

            while (l < r) {
                const sum = nums[i] + nums[j] + nums[l] + nums[r];

                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    res.push([nums[i], nums[j], nums[l], nums[r]]);
                    while (l + 1 < r && nums[l] === nums[l + 1]) {
                        l++;
                    }
                    while (l < r - 1 && nums[r] === nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
    }

    return res;
};
