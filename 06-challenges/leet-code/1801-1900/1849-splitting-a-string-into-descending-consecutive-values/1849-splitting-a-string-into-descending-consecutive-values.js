// https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/

var splitString = function(s) {
    function backtrack(start, prev, count) {
        if (start === s.length) {
            return count >= 2;
        }
        let num = 0;
        for (let end = start; end < s.length; end++) {
            num = num * 10 + Number(s[end]);
            if (num > 1e15) break;
            if (prev === -1 || num === prev - 1) {
                if (backtrack(end + 1, num, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
    return backtrack(0, -1, 0);
};
