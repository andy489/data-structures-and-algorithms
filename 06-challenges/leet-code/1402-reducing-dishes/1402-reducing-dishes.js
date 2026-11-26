// https://leetcode.com/problems/reducing-dishes/

var maxSatisfaction = function(satisfaction) {
    satisfaction.sort((a, b) => b - a);
    let total = 0, suffix = 0;
    for (const s of satisfaction) {
        if (suffix + s <= 0) break;
        suffix += s;
        total += suffix;
    }
    return total;
};
