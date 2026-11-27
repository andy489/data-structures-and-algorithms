// https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/

// Solution: Substring Check — O(n) time, O(1) space
var checkString = function(s) {
    return !s.includes("ba");
};

// Solution 2: Linear Scan — O(n) time, O(1) space
var checkString2 = function(s) {
    let seenB = false;

    for (const c of s) {
        if (c === 'b') {
            seenB = true;
        } else if (seenB) {
            return false;
        }
    }

    return true;
};
