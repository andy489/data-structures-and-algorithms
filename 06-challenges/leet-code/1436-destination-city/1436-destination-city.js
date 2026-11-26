// https://leetcode.com/problems/destination-city/

var destCity = function(paths) {
    const sources = new Set(paths.map(p => p[0]));
    return paths.find(p => !sources.has(p[1]))[1];
};
