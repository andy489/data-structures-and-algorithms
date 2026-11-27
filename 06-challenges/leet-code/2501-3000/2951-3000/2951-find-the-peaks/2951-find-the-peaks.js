// https://leetcode.com/problems/find-the-peaks/
var findPeaks = function(mountain) {
    const peaks = [];
    for (let i = 1; i < mountain.length - 1; i++) {
        if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
            peaks.push(i);
        }
    }
    return peaks;
};
