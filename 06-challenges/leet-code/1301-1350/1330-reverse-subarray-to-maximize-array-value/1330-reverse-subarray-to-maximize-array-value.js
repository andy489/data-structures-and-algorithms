// https://leetcode.com/problems/reverse-subarray-to-maximize-array-value/

var maxValueAfterReverse = function(nums) {
    const n = nums.length;
    let base = 0;
    for (let i = 0; i < n-1; i++) base += Math.abs(nums[i]-nums[i+1]);
    let gain = 0;
    for (let i = 1; i < n-1; i++) {
        gain = Math.max(gain, Math.abs(nums[0]-nums[i+1])-Math.abs(nums[i]-nums[i+1]));
        gain = Math.max(gain, Math.abs(nums[n-1]-nums[i-1])-Math.abs(nums[i]-nums[i-1]));
    }
    for (let i = 0; i < n-1; i++) {
        const lo1=Math.min(nums[i],nums[i+1]), hi1=Math.max(nums[i],nums[i+1]);
        for (let j = i+1; j < n-1; j++) {
            const lo2=Math.min(nums[j],nums[j+1]), hi2=Math.max(nums[j],nums[j+1]);
            gain = Math.max(gain, 2*(Math.min(hi1,hi2)-Math.max(lo1,lo2)));
        }
    }
    return base + gain;
};
