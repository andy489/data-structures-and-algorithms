// https://leetcode.com/problems/beautiful-array/

var beautifulArray = function(n) {
    let result = [1];
    while (result.length < n) {
        result = [...result.map(x => 2*x-1), ...result.map(x => 2*x)];
    }
    return result.filter(x => x <= n);
};
