// https://leetcode.com/problems/traffic-signal-color/
class Solution {
    public String trafficSignalColor(int timer) {
        if (timer == 0) {
            return "Green";
        } else if (timer == 30) {
            return "Orange";
        } else if (timer > 30 && timer <= 90) {
            return "Red";
        } else {
            return "Invalid";
        }
    }
}
