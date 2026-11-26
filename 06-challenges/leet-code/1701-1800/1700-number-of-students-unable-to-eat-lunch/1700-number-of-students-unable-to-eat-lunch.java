// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

// Solution: Count-Based Simulation — O(n) time, O(1) space
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int s : students) {
            count[s]++;
        }
        for (int sandwich : sandwiches) {
            if (count[sandwich] == 0) {
                return count[0] + count[1];
            }
            count[sandwich]--;
        }
        return 0;
    }
}
