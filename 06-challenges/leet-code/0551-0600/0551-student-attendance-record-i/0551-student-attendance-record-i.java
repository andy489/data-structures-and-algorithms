// https://leetcode.com/problems/student-attendance-record-i/
// Solution: String scan — O(n) time, O(1) space
class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absentCount++;
                if (absentCount >= 2) {
                    return false;
                }
            }
        }
        return !s.contains("LLL");
    }
}
