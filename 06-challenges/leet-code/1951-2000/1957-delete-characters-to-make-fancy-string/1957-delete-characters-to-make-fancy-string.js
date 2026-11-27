// https://leetcode.com/problems/delete-characters-to-make-fancy-string/
var makeFancyString = function(s) {
    const result = [];
    for (const c of s) {
        const n = result.length;
        if (n >= 2 && result[n - 1] === c && result[n - 2] === c) {
            continue;
        }
        result.push(c);
    }
    return result.join('');
};
