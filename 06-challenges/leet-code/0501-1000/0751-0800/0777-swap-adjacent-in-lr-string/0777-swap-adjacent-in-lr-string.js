// https://leetcode.com/problems/swap-adjacent-in-lr-string/

var canTransform = function(start, result) {
    const n = start.length;
    let i = 0, j = 0;
    while (i < n || j < n) {
        while (i < n && start[i] === 'X') i++;
        while (j < n && result[j] === 'X') j++;
        if (i === n && j === n) return true;
        if (i === n || j === n) return false;
        if (start[i] !== result[j]) return false;
        if (start[i] === 'L' && j > i) return false;
        if (start[i] === 'R' && j < i) return false;
        i++;
        j++;
    }
    return true;
};
