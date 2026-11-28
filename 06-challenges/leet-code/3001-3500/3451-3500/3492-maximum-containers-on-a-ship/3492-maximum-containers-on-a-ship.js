// https://leetcode.com/problems/maximum-containers-on-a-ship/

var maxContainers = function(n, w, maxWeight) {
    return Math.min(n * n, Math.floor(maxWeight / w));
};
