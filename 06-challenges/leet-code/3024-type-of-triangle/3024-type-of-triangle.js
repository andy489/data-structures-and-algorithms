// https://leetcode.com/problems/type-of-triangle/

var triangleType = function(nums) {
    nums.sort((a,b) => a-b);
    const [a,b,c] = nums;
    if (a+b <= c) return "none";
    if (a === c) return "equilateral";
    if (a === b || b === c) return "isosceles";
    return "scalene";
};
