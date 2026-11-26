// https://leetcode.com/problems/sort-colors/

// Solution 1: Counting Sort — O(n) time, O(1) space (two passes)
var sortColors = function(nums) {
    const count = [0, 0, 0];

    for (const num of nums) {
        count[num]++;
    }

    let k = 0;
    for (let color = 0; color < 3; color++) {
        for (let j = 0; j < count[color]; j++) {
            nums[k++] = color;
        }
    }
};

// Solution 2: Dutch National Flag — O(n) time, O(1) space (one pass)
var sortColors2 = function(nums) {
    let lo = 0, mid = 0, hi = nums.length - 1;

    while (mid <= hi) {
        if (nums[mid] === 0) {
            [nums[lo], nums[mid]] = [nums[mid], nums[lo]];
            lo++;
            mid++;
        } else if (nums[mid] === 1) {
            mid++;
        } else {
            [nums[mid], nums[hi]] = [nums[hi], nums[mid]];
            hi--;
        }
    }
};
