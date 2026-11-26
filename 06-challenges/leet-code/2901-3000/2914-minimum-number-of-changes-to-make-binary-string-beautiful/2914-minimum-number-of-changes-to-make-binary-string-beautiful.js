// https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/

// Solution 1: Greedy Pair Scan — O(n) time, O(1) space
var minChanges = function(s) {
    let changes = 0;
    for (let i = 0; i < s.length; i += 2) {
        if (s[i] !== s[i + 1]) changes++;
    }
    return changes;
};

// Solution 2: Greedy Segment Scan — O(n) time, O(1) space
var minChanges2 = function(s) {
    let changes = 0, len = 1;
    for (let i = 1; i < s.length; i++) {
        if (s[i] === s[i - 1]) {
            len++;
        } else {
            if (len % 2 === 1) changes++;
            len = 1;
        }
    }
    return changes;
};
