// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
var largestPerimeter = function(nums) {
    nums.sort((a, b) => a - b);
    let prefixSum = 0;
    let result = -1;
    for (const num of nums) {
        if (prefixSum > num) {
            result = prefixSum + num;
        }
        prefixSum += num;
    }
    return result;
};
