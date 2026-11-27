// https://leetcode.com/problems/count-tested-devices-after-test-operations/
class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int tested = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] - tested > 0) {
                tested++;
            }
        }
        return tested;
    }
}
