// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

var longestSubarray = function(nums) {
    let left=0,zeros=0,ans=0;
    for(let r=0;r<nums.length;r++){
        if(!nums[r])zeros++;
        while(zeros>1)if(!nums[left++])zeros--;
        ans=Math.max(ans,r-left);
    }
    return ans;
};
