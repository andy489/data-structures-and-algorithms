// https://leetcode.com/problems/angle-between-hands-of-a-clock/

// Solution: Math — O(1) time, O(1) space
class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = minutes * 6.0;
        double hourAngle = (hour % 12) * 30.0 + minutes * 0.5;
        double diff = Math.abs(minuteAngle - hourAngle);
        return Math.min(diff, 360.0 - diff);
    }
}
