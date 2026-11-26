// https://leetcode.com/problems/split-array-into-consecutive-subsequences/

var isPossible = function(nums) {
    const freq = new Map();
    const appendFreq = new Map();
    for (const num of nums) freq.set(num, (freq.get(num) || 0) + 1);
    for (const num of nums) {
        if ((freq.get(num) || 0) === 0) continue;
        if ((appendFreq.get(num) || 0) > 0) {
            appendFreq.set(num, appendFreq.get(num) - 1);
            appendFreq.set(num + 1, (appendFreq.get(num + 1) || 0) + 1);
        } else if ((freq.get(num + 1) || 0) > 0 && (freq.get(num + 2) || 0) > 0) {
            freq.set(num + 1, freq.get(num + 1) - 1);
            freq.set(num + 2, freq.get(num + 2) - 1);
            appendFreq.set(num + 3, (appendFreq.get(num + 3) || 0) + 1);
        } else {
            return false;
        }
        freq.set(num, freq.get(num) - 1);
    }
    return true;
};
