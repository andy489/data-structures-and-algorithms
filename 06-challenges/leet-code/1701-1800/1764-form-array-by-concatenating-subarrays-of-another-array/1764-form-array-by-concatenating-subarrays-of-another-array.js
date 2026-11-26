// https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/

var canChoose = function(groups, nums) {
    let pos = 0;
    for (const g of groups) {
        let found = false;
        while (pos + g.length <= nums.length) {
            if (g.every((v, i) => nums[pos + i] === v)) {
                pos += g.length;
                found = true;
                break;
            }
            pos++;
        }
        if (!found) return false;
    }
    return true;
};
