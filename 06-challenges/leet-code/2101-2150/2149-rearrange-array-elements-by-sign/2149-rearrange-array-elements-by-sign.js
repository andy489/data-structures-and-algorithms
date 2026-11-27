// https://leetcode.com/problems/rearrange-array-elements-by-sign/
var rearrangeArray = function(nums) {
    const result = new Array(nums.length);
    let posIdx = 0;
    let negIdx = 1;
    for (const x of nums) {
        if (x > 0) {
            result[posIdx] = x;
            posIdx += 2;
        } else {
            result[negIdx] = x;
            negIdx += 2;
        }
    }
    return result;
};
