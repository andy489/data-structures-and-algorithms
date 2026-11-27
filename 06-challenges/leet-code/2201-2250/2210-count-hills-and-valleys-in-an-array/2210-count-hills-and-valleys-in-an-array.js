// https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
var countHillValley = function(nums) {
    const dedup = [];
    for (const num of nums) {
        if (dedup.length === 0 || dedup[dedup.length - 1] !== num) {
            dedup.push(num);
        }
    }
    let count = 0;
    for (let i = 1; i < dedup.length - 1; i++) {
        if (dedup[i] > dedup[i - 1] && dedup[i] > dedup[i + 1]) {
            count++;
        } else if (dedup[i] < dedup[i - 1] && dedup[i] < dedup[i + 1]) {
            count++;
        }
    }
    return count;
};
