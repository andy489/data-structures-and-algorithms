// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

var removeDuplicates = function(nums) {
    let k = 0;
    for (const x of nums) {
        if (k < 2 || x !== nums[k - 2]) {
            nums[k++] = x;
        }
    }
    return k;
};
