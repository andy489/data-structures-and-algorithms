// https://leetcode.com/problems/number-of-lines-to-write-string/

var numberOfLines = function(widths, s) {
    let lines = 1, cur = 0;
    for (const c of s) {
        const w = widths[c.charCodeAt(0) - 97];
        if (cur + w > 100) {
            lines++;
            cur = 0;
        }
        cur += w;
    }
    return [lines, cur];
};
