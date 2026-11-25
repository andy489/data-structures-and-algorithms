// https://leetcode.com/problems/bulb-switcher-ii/

// Solution: Math/Observation — O(1) time, O(1) space
class Solution {
    public int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return presses == 1 ? 3 : 4;
        }
        if (presses == 1) {
            return 4;
        }
        if (presses == 2) {
            return 7;
        }
        return 8;
    }
}
