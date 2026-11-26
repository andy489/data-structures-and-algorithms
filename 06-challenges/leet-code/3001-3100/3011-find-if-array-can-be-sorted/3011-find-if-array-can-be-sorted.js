// https://leetcode.com/problems/find-if-array-can-be-sorted/

var canSortArray = function(nums) {
    const popcount = x => { let c=0; while(x){c+=x&1;x>>=1;} return c; };
    let prevMax = 0, curMin = nums[0], curMax = nums[0], curBits = popcount(nums[0]);
    for (let i = 1; i < nums.length; i++) {
        const bits = popcount(nums[i]);
        if (bits === curBits) {
            curMin = Math.min(curMin, nums[i]);
            curMax = Math.max(curMax, nums[i]);
        } else {
            if (curMin < prevMax) return false;
            prevMax = curMax;
            curMin = curMax = nums[i];
            curBits = bits;
        }
    }
    return curMin >= prevMax;
};
