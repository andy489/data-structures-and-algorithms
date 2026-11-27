// https://leetcode.com/problems/maximum-distance-in-arrays/

var maxDistance = function(arrays) {
    let globalMin = arrays[0][0];
    let globalMax = arrays[0][arrays[0].length - 1];
    let result = 0;
    for (let i = 1; i < arrays.length; i++) {
        const first = arrays[i][0];
        const last = arrays[i][arrays[i].length - 1];
        result = Math.max(result, last - globalMin, globalMax - first);
        globalMin = Math.min(globalMin, first);
        globalMax = Math.max(globalMax, last);
    }
    return result;
};
