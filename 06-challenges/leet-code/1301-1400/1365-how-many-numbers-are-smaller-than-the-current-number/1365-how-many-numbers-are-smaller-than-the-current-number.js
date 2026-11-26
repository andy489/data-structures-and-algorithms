// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

var smallerNumbersThanCurrent = function(nums) {
    const cnt=new Array(102).fill(0);
    for(const v of nums) cnt[v+1]++;
    for(let i=1;i<cnt.length;i++) cnt[i]+=cnt[i-1];
    return nums.map(v=>cnt[v]);
};
