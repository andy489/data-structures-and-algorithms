// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

var maxUniqueSplit = function(s) {
    let maxCount = 0;
    function backtrack(start, used) {
        if (s.length - start + used.size <= maxCount) return;
        if (start === s.length) {
            maxCount = Math.max(maxCount, used.size);
            return;
        }
        for (let end = start + 1; end <= s.length; end++) {
            const sub = s.slice(start, end);
            if (!used.has(sub)) {
                used.add(sub);
                backtrack(end, used);
                used.delete(sub);
            }
        }
    }
    backtrack(0, new Set());
    return maxCount;
};
