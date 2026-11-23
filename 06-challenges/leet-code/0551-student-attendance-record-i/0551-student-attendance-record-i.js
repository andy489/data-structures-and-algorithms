// https://leetcode.com/problems/student-attendance-record-i/
// Solution: String scan — O(n) time, O(1) space
var checkRecord = function(s) {
    return (s.split('A').length - 1) < 2 && !s.includes('LLL');
};
