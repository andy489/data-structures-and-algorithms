// https://leetcode.com/problems/total-hamming-distance/

var totalHammingDistance = function(nums) {
    let total = 0;
    const n = nums.length;
    for (let bit = 0; bit < 32; bit++) {
        let onesCount = 0;
        for (const num of nums) {
            onesCount += (num >> bit) & 1;
        }
        total += onesCount * (n - onesCount);
    }
    return total;
};
