// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/

var lexicographicallySmallestArray = function(nums, limit) {
    const n = nums.length;
    const indices = Array.from({length: n}, (_, i) => i);
    indices.sort((a, b) => nums[a] - nums[b]);

    const result = new Array(n);
    let i = 0;
    while (i < n) {
        let j = i + 1;
        while (j < n && nums[indices[j]] - nums[indices[j - 1]] <= limit) {
            j++;
        }
        const groupIdx = indices.slice(i, j).slice().sort((a, b) => a - b);
        for (let x = i; x < j; x++) {
            result[groupIdx[x - i]] = nums[indices[x]];
        }
        i = j;
    }
    return result;
};
