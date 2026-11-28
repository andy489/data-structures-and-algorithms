// https://leetcode.com/problems/minimum-number-of-groups-to-create-a-valid-assignment/

var minGroupsForValidAssignment = function(nums) {
    const freq = new Map();
    for (const x of nums) {
        freq.set(x, (freq.get(x) || 0) + 1);
    }

    const freqVals = [...freq.values()];
    const minFreq = Math.min(...freqVals);

    for (let k = minFreq; k >= 1; k--) {
        let boxes = 0;
        let valid = true;
        for (const f of freqVals) {
            if (f < k) { valid = false; break; }
            boxes += Math.ceil(f / (k + 1));
        }
        if (valid) return boxes;
    }
    return nums.length;
};
