// https://leetcode.com/problems/get-equal-substrings-within-budget/

var equalSubstring = function(s, t, maxCost) {
    let l = 0, cost = 0, res = 0;
    for (let r = 0; r < s.length; r++) {
        cost += Math.abs(s.charCodeAt(r) - t.charCodeAt(r));
        while (cost > maxCost) cost -= Math.abs(s.charCodeAt(l) - t.charCodeAt(l++));
        res = Math.max(res, r - l + 1);
    }
    return res;
};
