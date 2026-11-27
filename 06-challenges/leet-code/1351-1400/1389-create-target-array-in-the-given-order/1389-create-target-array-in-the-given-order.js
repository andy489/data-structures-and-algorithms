// https://leetcode.com/problems/create-target-array-in-the-given-order/

var createTargetArray = function(nums, index) {
    const target=[];
    for(let i=0;i<nums.length;i++) target.splice(index[i],0,nums[i]);
    return target;
};
