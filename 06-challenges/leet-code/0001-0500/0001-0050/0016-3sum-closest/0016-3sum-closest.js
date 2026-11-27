// https://leetcode.com/problems/3sum-closest/

var threeSumClosest = function(nums, target) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    let closestSum = nums[0] + nums[1] + nums[2];

    for (let i = 0; i < n - 2; i++) {
        let l = i + 1;
        let r = n - 1;

        while (l < r) {
            const curSum = nums[i] + nums[l] + nums[r];

            if (curSum === target) {
                return curSum;
            }

            if (Math.abs(curSum - target) < Math.abs(closestSum - target)) {
                closestSum = curSum;
            }

            if (curSum < target) {
                l++;
            } else {
                r--;
            }
        }
    }

    return closestSum;
};
