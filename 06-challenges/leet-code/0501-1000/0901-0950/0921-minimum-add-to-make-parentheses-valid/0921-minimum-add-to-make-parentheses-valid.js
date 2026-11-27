// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

var minAddToMakeValid = function(s) {
    let open = 0, close = 0;
    for (const c of s) {
        if (c === '(') open++;
        else if (open > 0) open--;
        else close++;
    }
    return open + close;
};
