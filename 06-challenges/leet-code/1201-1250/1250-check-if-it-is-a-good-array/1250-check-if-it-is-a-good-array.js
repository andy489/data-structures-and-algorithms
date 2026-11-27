// https://leetcode.com/problems/check-if-it-is-a-good-array/

var isGoodArray = function(nums) {
    const g=(a,b)=>b===0?a:g(b,a%b);
    return nums.reduce(g)===1;
};
