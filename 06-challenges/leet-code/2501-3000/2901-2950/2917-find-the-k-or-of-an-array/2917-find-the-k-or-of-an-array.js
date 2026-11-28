// https://leetcode.com/problems/find-the-k-or-of-an-array/

var findKOr = function(nums, k) {
    let result = 0;
    for (let b = 0; b < 31; b++) {
        let count = 0;
        for (const num of nums) {
            if (((num >> b) & 1) === 1) count++;
        }
        if (count >= k) result |= (1 << b);
    }
    return result;
};
