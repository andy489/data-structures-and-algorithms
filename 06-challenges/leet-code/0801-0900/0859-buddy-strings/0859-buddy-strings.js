// https://leetcode.com/problems/buddy-strings/

var buddyStrings = function(s, goal) {
    if (s.length !== goal.length) return false;
    const diffs = [];
    const freq = new Array(26).fill(0);
    let hasDup = false;
    for (let i = 0; i < s.length; i++) {
        if (s[i] !== goal[i]) diffs.push(i);
        if (++freq[s.charCodeAt(i) - 97] === 2) hasDup = true;
    }
    if (diffs.length === 0) return hasDup;
    if (diffs.length === 2) {
        const [i, j] = diffs;
        return s[i] === goal[j] && s[j] === goal[i];
    }
    return false;
};
